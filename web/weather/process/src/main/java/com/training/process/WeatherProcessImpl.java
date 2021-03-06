package com.training.process;

import com.training.model.Weather;
import org.json.JSONObject;

public class WeatherProcessImpl implements WeatherProcess {
    private FetchWeatherProcess connToApi;

    public Weather getWeather(String city) {
        Weather weather = new Weather();
        try {
            JSONObject rawData = new JSONObject(connToApi.getWeatherInfo(city));
            if (rawData.get("cod").toString().equals("404")) {
                weather.setError(rawData.get("cod").toString());
                weather.setCity(city + " city name wasn't found");
            } else {
                weather.setTemperature(Double.toString(rawData.getJSONObject("main").getDouble("temp")));
                weather.setWind(Integer.toString(rawData.getJSONObject("wind").getInt("speed")));
                weather.setCity(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weather;
    }

    public FetchWeatherProcess getConnToApi() {
        return connToApi;
    }

    public void setConnToApi(FetchWeatherProcess connToApi) {
        this.connToApi = connToApi;
    }
}
