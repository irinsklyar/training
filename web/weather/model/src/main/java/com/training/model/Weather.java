package com.training.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@XmlRootElement(name = "weather")
public class Weather {

    private String city;
    private String temperature;
    private String wind;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        return new EqualsBuilder()
                .append(city, weather.city)
                .append(temperature, weather.temperature)
                .append(wind, weather.wind)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(city)
                .append(temperature)
                .append(wind)
                .toHashCode();
    }
}
