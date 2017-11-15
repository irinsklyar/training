package com.training.process;

import com.training.model.Weather;

public class Test {
    public static void main(String[] args) {
        WeatherProcessImpl weatherProcess = new WeatherProcessImpl();
        weatherProcess.setConnToApi(new FetchWeatherProcess());
        Weather kharkiv = weatherProcess.getWeather("kharki");

        System.out.println("GG");
    }
}
