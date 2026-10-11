package mz.co.lxrd;

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
                    System.out.println("Por implementar");
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