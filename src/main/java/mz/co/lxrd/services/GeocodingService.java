package mz.co.lxrd.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mz.co.lxrd.model.CityData;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GeocodingService {

    HttpClient client = HttpClient.newHttpClient();

    public CityData obterCoordenadas(String cidade){
        String urlRequest="https://geocoding-api.open-meteo.com/v1/search?name="
                + cidade + "&count=1&language=pt&format=json";

        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlRequest)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(response.body());
            JsonNode cidadeEncontrada = root.path("results").get(0);

            String pais = cidadeEncontrada.path("country").asText();
            double latitude = cidadeEncontrada
                    .path("latitude").asDouble();

            double longitude = cidadeEncontrada
                    .path("longitude").asDouble();

            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);
            CityData cityData = new CityData(cidade, pais, latitude, longitude);
            return cityData;
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
