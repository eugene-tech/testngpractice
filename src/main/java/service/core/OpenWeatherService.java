package service.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import service.dto.OpenWeatherDTO;

import java.io.IOException;

public class OpenWeatherService {

    public OpenWeatherDTO getOpenWeatherData() throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("https://openweathermap.org/data/2.5/weather?id=618426&units=metric&appid=439d4b804bc8187953eb36d2a8c26a02");
        CloseableHttpResponse response = client.execute(get);
        String jsonBody = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        OpenWeatherDTO openWeatherData = objectMapper.readValue(jsonBody,
                new TypeReference<OpenWeatherDTO>() {
                });

        client.close();
        response.close();

        return openWeatherData;
    }
}
