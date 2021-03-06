package com.training.service;

import com.training.model.Weather;
import com.training.process.WeatherProcess;

public class WeatherServiceImpl implements WeatherService {
    private WeatherProcess weatherProcess;

    public Weather parseWeather(String city) {
        return weatherProcess.getWeather(city);
    }

    public WeatherProcess getWeatherProcess() {
        return weatherProcess;
    }

    public void setWeatherProcess(WeatherProcess weatherProcess) {
        this.weatherProcess = weatherProcess;
    }
}
