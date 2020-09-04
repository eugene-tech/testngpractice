package service.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import service.core.MoldovaPageHTMLParser;
import service.core.OpenWeatherService;
import service.dto.OpenWeatherDTO;

import java.io.IOException;

public class TemperatureTest {
    @Test(description = "RM-206")
    public void currentWeatherCenterTest() throws IOException {
        OpenWeatherService openWeatherService = new OpenWeatherService();
        OpenWeatherDTO openWeatherDTO = openWeatherService.getOpenWeatherData();

        int openWeatherTemperature = openWeatherDTO.getMain().getTemp().intValue();

        MoldovaPageHTMLParser moldovaPage = new MoldovaPageHTMLParser();

        int moldovaPageTemperature = moldovaPage.getNightTemperatureCenter();
        int difference = Math.abs(moldovaPageTemperature - openWeatherTemperature);

        System.out.println("Moldova website temperature: " + moldovaPageTemperature);
        System.out.println("International website temperature: " + openWeatherTemperature);

        Assert.assertTrue(difference <= 3);
    }
}
