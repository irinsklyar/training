package com.training.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "weather")
public class Weather {

    private String city;
    private String temperature;
    private String wind;
    public Map<String,String> map;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (!city.equals(weather.city)) return false;
        if (!temperature.equals(weather.temperature)) return false;
        if (!wind.equals(weather.wind)) return false;
        return map != null ? map.equals(weather.map) : weather.map == null;
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + temperature.hashCode();
        result = 31 * result + wind.hashCode();
        result = 31 * result + (map != null ? map.hashCode() : 0);
        return result;
    }

    public Weather() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
//    json
}
