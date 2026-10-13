package mz.co.lxrd.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import mz.co.lxrd.model.CityData;

import java.net.ConnectException;
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
            System.out.println("Aguarde...");
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlRequest)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(response.body());
            JsonNode cidadeEncontrada = root.path("results").get(0);

            String pais = cidadeEncontrada.path("country").asText();
            double latitude = cidadeEncontrada
                    .path("latitude").asDouble();

            double longitude = cidadeEncontrada
                    .path("longitude").asDouble();

            CityData cityData = new CityData(cidade, pais, latitude, longitude);
            return cityData;
        }catch (ConnectException e){
            System.out.println("Verifique a sua internet!");
        } catch (Exception e){
            System.out.println("Houve um erro a buscar as coordenadas!");
        }
        return null;
    }
}
