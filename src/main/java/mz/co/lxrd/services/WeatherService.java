package mz.co.lxrd.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class WeatherService {
    public String consultarMeteorologia(Map<String, Double> map){
        HttpClient client = HttpClient.newHttpClient();

        String urlRequest = "https://api.open-meteo.com/v1/forecast?latitude="+map.get("latitude")+"&longitude="+map.get("longitude")+"&current=temperature_2m,relative_humidity_2m,wind_speed_10m";
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlRequest)).GET().build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println(response.body());
            } else {
                System.out.println("erro http " + response.statusCode());
                System.out.println(response.body());
            }
        }catch (Exception e) {
            System.out.println("Ocorreu um erro a buscar a meteorologia! ");
        }
        return  "";
    }
}
