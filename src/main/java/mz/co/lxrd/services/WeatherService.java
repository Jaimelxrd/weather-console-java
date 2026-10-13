package mz.co.lxrd.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mz.co.lxrd.model.CityData;
import mz.co.lxrd.model.WeatherData;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherService {

    public WeatherData consultarMeteorologia(CityData cityData){

        HttpClient client = HttpClient.newHttpClient();

        String urlRequest = "https://api.open-meteo.com/v1/forecast?latitude="+cityData.getLatitude()+"&longitude="+cityData.getLongitude()+"&current=temperature_2m,relative_humidity_2m,wind_speed_10m";
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlRequest)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {

                ObjectMapper mapper = new ObjectMapper();

                JsonNode root = mapper.readTree(response.body());
                JsonNode current = root.path("current");

                double temperatura = current.path("temperature_2m").asDouble();
                int humidade = current.path("relative_humidity_2m").asInt();
                double velocidadeVento = current.path("wind_speed_10m").asDouble();
                String horaConsulta = current.path("time").asText();

               WeatherData weather = new WeatherData(temperatura, humidade, velocidadeVento, horaConsulta);
                return weather;

            } else {
                System.out.println("erro http " + response.statusCode());
                System.out.println(response.body());
            }
        }catch (Exception e) {
            System.out.println("Ocorreu um erro a buscar a meteorologia! ");
        }
        return  null;
    }
}
