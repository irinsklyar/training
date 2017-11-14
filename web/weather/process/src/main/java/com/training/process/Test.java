package com.training.process;

public class Test {


    public static void main(String[] args) {
        WeatherProcessImpl weatherProcess= new WeatherProcessImpl();


        System.out.println(weatherProcess.getWeather("Lviv").getTemperature());

    }
}
