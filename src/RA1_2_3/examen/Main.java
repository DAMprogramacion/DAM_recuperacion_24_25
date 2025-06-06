package RA1_2_3.examen;

import RA1_2_3.Helper;
import RA1_2_3.examen.auxiliar.HelperAux;
import RA1_2_3.examen.modelo.Airport;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Airport> airports = HelperAux.listarAeropuertos("files/airportData.csv");
    public static void main(String[] args) {
        String menu = """
                APLICACIÓN AEROPUERTO:
                1. Aeropuertos por altitud.
                2. Aeropuerto de mayor altitud.
                3. Número de aeropuertos por paı́s.
                4. Tres aeropuertos por continente.
                5. Salir.
                """;
        int option = -1;
        do {
            System.out.println(menu);
            System.out.println("Introduce option:");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> showAirportsByElevation();
                case 2 -> showAirportGreatesElevation();
                case 3 -> showNumberOfAirportsByCountry();
                case 4 -> showThreeAirportsByContinent();
            }

        } while (option < 1 || option > 5);
        System.out.println("Bye bye");

    }

    private static void showThreeAirportsByContinent() {
        System.out.println("\nIntroduce continent code: ");
        String continent = scanner.nextLine();
        List<Airport> airportRandom = HelperAux.getRandomAirports(airports, continent );
        airportRandom.forEach(System.out::println);
        System.out.println();
        scanner.nextLine();
    }

    private static void showNumberOfAirportsByCountry() {
        System.out.println("\nIntroduce country code: ");
        String code = scanner.nextLine();
        int numberOfAirports = HelperAux.numberOfAirportByCountry(airports, code);
        System.out.printf("Number of airports of %s: %d%n", code, numberOfAirports);
        System.out.println();
        scanner.nextLine();

    }

    private static void showAirportGreatesElevation() {
        System.out.println();
        System.out.println(HelperAux.getAirportWithGreatestElevation(airports));
        System.out.println();
        scanner.nextLine();

    }

    private static void showAirportsByElevation() {
        System.out.println("\nIntroduce the elevation: ");
        int elevation = scanner.nextInt();
        scanner.nextLine();
        List<Airport> airportList = HelperAux.getAirportsByElevation(airports, elevation);
        airportList.forEach(System.out::println);
        System.out.println();
    }


}
