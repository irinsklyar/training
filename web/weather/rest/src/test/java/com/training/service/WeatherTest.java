package com.training.service;

import com.training.model.Weather;
import com.training.process.ConnToApi;
import com.training.process.WeatherProcessImpl;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

import static com.training.process.ConnToApi.jsonStringToHashMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class WeatherTest {
    @Mock
    private ConnToApi connToApi;
    @InjectMocks
    private WeatherProcessImpl weatherProcess;
//    private WeatherServiceImpl weatherService;

    @Test
    public void shouldReturnExpectedWeatherObject() throws Exception {
        //given
        Weather weatherExpected = new Weather();
        weatherExpected.setCity("Lviv");
        weatherExpected.setTemperature("{\"temp\":277.15,\"temp_min\":277.15,\"humidity\":100,\"pressure\":1021,\"temp_max\":277.15}");
        weatherExpected.setWind("{\"deg\":320,\"speed\":4}");

        String json_string = "{\"coord\":{\"lon\":24.02,\"lat\":49.84},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"base\":\"stations\",\"main\":{\"temp\":277.15,\"pressure\":1021,\"humidity\":100,\"temp_min\":277.15,\"temp_max\":277.15},\"visibility\":10000,\"wind\":{\"speed\":4,\"deg\":320},\"clouds\":{\"all\":90},\"dt\":1510657200,\"sys\":{\"type\":1,\"id\":7361,\"message\":0.0042,\"country\":\"UA\",\"sunrise\":1510637720,\"sunset\":1510670456},\"id\":702550,\"name\":\"Lviv\",\"cod\":200}";
        HashMap<String, String> hashMap = jsonStringToHashMap(json_string);
        when(connToApi.sendGet(anyString())).thenReturn(hashMap);
        //when
        Weather weatherActual = weatherProcess.getWeather("Lviv");
//        Weather weatherActual =weatherService.get("Lviv");
        //then
        assertEquals(weatherExpected,weatherActual);
    }
}
