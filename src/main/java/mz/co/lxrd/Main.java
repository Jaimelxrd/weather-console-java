package mz.co.lxrd;

import mz.co.lxrd.model.CityData;
import mz.co.lxrd.model.WeatherData;
import mz.co.lxrd.services.GeocodingService;
import mz.co.lxrd.services.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit){
            System.out.println("1-Consultar Meteorologia");
            System.out.println("2-Sair");
            int escolha = sc.nextInt();
            switch (escolha){
                case 1:
                    System.out.println("Digite o nome da cidade: ");
                    String nomeCidade = sc.nextLine();
                    nomeCidade.trim();
                    if(nomeCidade.isBlank()){
                        System.out.println("O campo nao pode ser vazio!");
                        return;
                    }
                    GeocodingService geocodingService = new GeocodingService();
                    CityData coordenadas = geocodingService.obterCoordenadas(nomeCidade);
                    if (coordenadas==null){
                        System.out.println("cidade nao encontrada!");
                        return;
                    }
                    WeatherService weatherService = new WeatherService();
                    WeatherData weatherData = weatherService.consultarMeteorologia(coordenadas);
                    if (weatherData==null){
                        return;
                    }
                    System.out.println("Cidade: "+coordenadas.getNome());
                    System.out.println("Pais: "+coordenadas.getPais());
                    System.out.println("Temperatura: " + weatherData.getTemperatura() + " °C");
                    System.out.println("Humidade: " +weatherData.getHumidade()  + "%");
                    System.out.println("Velocidade do vento: " + weatherData.getVelocidadeVento() + " km/h");
                    System.out.println("Hora da medição: " + weatherData.getHoraConsulta());
                    break;
                case 2:
                    exit=true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("opcao invalida!");
                    break;
            }
        }
    }
}