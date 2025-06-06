package RA1_2_3.examen.auxiliar;

import RA1_2_3.examen.excepciones.AltitudeException;
import RA1_2_3.examen.modelo.Airport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelperAux {
    public static List<Airport> listarAeropuertos(String path) {
        List<Airport> airports = new ArrayList<>();
        Path route = Path.of(path);
        try {
            List<String>  lines = Files.readAllLines (route);
            if (lines.size() == 0)
                return airports;
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] tokens = line.split(",");
                int elevation = -1;
                try {
                   /* if (! tokens[4].matches("-?[0-9]+"))
                        continue;*/
                    elevation = Integer.parseInt(tokens[4]);
                    Airport airport = new Airport(tokens[0], tokens[1], tokens[2],
                            tokens[3], elevation);
                    airports.add(airport);
                } catch (AltitudeException e) {
                    System.err.printf("%s: %s%n", e.getMessage(), tokens[4]);
                    //throw new RuntimeException(e);
                } catch (ArrayIndexOutOfBoundsException e){
                    System.err.println("invalide value");
                } catch (NumberFormatException e) {
                    System.err.println("invalide value");
                }

            }
        } catch (IOException e) {
            System.err.println("Problem with then path");
            //throw new RuntimeException(e);
        }
        return airports;
    }

   /* public static void main(String[] args) {
        List<Airport> airports = listarAeropuertos("files/airportData.csv");
        System.out.printf("Nº of register: %d%n", airports.size());
    }*/
    public static  List<Airport> getAirportsByElevation (List<Airport> airports, int elevation) {
        List<Airport> airportsElevation = new ArrayList<>();
        for (int i = 0; i < airports.size(); i++) {
            if (airports.get(i).getAirportElevation() >= elevation)
                airportsElevation.add(airports.get(i));
        }
        return airportsElevation;
    }
    public static Airport getAirportWithGreatestElevation(List<Airport> airports) {
        int altitude = 0;
        Airport airportElevation = null;
        for (Airport airport : airports) {
            if (airport.getAirportElevation() > altitude) {
                airportElevation = airport;
                altitude = airport.getAirportElevation();
            }
        }
        return airportElevation;
    }
    public static int numberOfAirportByCountry(List<Airport> airports, String countryCode) {
        int count = 0;
        for (Airport airport : airports)
            if (airport.getAirportCountryCode().equalsIgnoreCase(countryCode))
                count++;
        return count;
    }
    public static List<Airport> getRandomAirports(List<Airport> airports, String continentCode) {
        List<Airport> allAirportByContinent = new ArrayList<>();
        List<Airport> airportsRandom = new ArrayList<>();
        for (Airport airport : airports)
            if (airport.getAirportContinent().equalsIgnoreCase(continentCode))
                allAirportByContinent.add(airport);
        do {
            int random = new Random().nextInt(allAirportByContinent.size());
            if (!airportsRandom.contains(allAirportByContinent.get(random)))
                airportsRandom.add(allAirportByContinent.get(random));
        } while (allAirportByContinent.size() < 3);
        return airportsRandom;
    }







}






