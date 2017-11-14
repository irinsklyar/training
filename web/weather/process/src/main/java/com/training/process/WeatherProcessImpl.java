package com.training.process;

import com.training.model.Weather;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class WeatherProcessImpl implements WeatherProcess {
    private static String urlPart1="http://api.openweathermap.org/data/2.5/weather?q=";
    private static String urlPart2=",ua&appid=d8f9d06a92d4555ddf801b77091b8dc8";
    ConnToApi connToApi=new ConnToApi();

    public Weather getWeather(String name) {
        String url = urlPart1 + name + urlPart2;
        Weather weather = new Weather();
        try {
            HashMap<String ,String> hashMap= connToApi.sendGet(url);
            weather.setTemperature(hashMap.get("main"));
            weather.setWind(hashMap.get("wind"));
            weather.setCity(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weather;
    }

}
