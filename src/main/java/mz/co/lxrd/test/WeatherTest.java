package mz.co.lxrd.test;

import mz.co.lxrd.services.GeocodingService;
import mz.co.lxrd.services.WeatherService;

import java.util.Map;

public class WeatherTest {
    public static void main(String[] args) {
        String cidade = "Maputo";

        GeocodingService gs = new GeocodingService();
        WeatherService ws = new WeatherService();

        Map<String, Double> cordenadas =gs.obterCoordenadas(cidade);
        System.out.println(ws.consultarMeteorologia(cordenadas));


    }
}
