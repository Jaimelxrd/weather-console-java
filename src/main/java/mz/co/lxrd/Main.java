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

        GeocodingService geocodingService = new GeocodingService();
        WeatherService weatherService = new WeatherService();

        while (!exit) {
            System.out.println("----------------------------------");
            System.out.println("        JAVA WEATHER APP Console");
            System.out.println("----------------------------------");
            System.out.println("1 - Consultar meteorologia");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = sc.nextLine();

            int escolha;

            try {
                escolha = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Erro: introduza uma opção numérica.");
                continue;
            }

            switch (escolha) {

                case 1:
                    System.out.print("Digite o nome da cidade: ");
                    String nomeCidade = sc.nextLine().trim();

                    if (nomeCidade.isBlank()) {
                        System.out.println("Erro: o nome da cidade não pode ser vazio.");
                        break;
                    }

                    CityData coordenadas =
                            geocodingService.obterCoordenadas(nomeCidade);

                    if (coordenadas == null) {
                        System.out.println("Não foi possível encontrar a cidade.");
                        break;
                    }

                    WeatherData weatherData =
                            weatherService.consultarMeteorologia(coordenadas);

                    if (weatherData == null) {
                        System.out.println("Não foi possível obter a meteorologia.");
                        break;
                    }

                    System.out.println("........................");
                    System.out.println("RESULTADO METEOROLÓGICO");
                    System.out.println("........................");

                    System.out.println("Cidade: " + coordenadas.getNome());
                    System.out.println("País: " + coordenadas.getPais());
                    System.out.println("Temperatura: "
                            + weatherData.getTemperatura() + " °C");
                    System.out.println("Humidade: "
                            + weatherData.getHumidade() + "%");
                    System.out.println("Velocidade do vento: "
                            + weatherData.getVelocidadeVento() + " km/h");
                    System.out.println("Hora da medição: "
                            + weatherData.getHoraConsulta());
                    break;

                case 2:
                    exit = true;
                    System.out.println("A sair da aplicação...");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha 1 ou 2.");
                    break;
            }
        }

        sc.close();
        System.out.println("Aplicação encerrada.");
    }
}