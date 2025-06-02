package RA1_2_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioRA_1_2_3_file {
    public static void main(String[] args) {
        List<Person> people = readPeople("files/people.csv");
        System.out.printf("Leidos %d registros%n", people.size());
       // System.out.println(people.get(1000));

        //USANDO BUCLES
        //metodo que devuelva en numero de personas dado el género
        //metodo que nos devuelva un array de 4 listas  //comentados
        //primera de clase A, segunda clase B, tercer clase C , cuarta clase D  //comentados
    }

    private static List<Person> readPeople(String path) {
        List<Person> people = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            scanner.nextLine(); //omitimos la cabecera
            while (scanner.hasNextLine()) {
                String linea =  scanner.nextLine();
                String[] tokens = linea.split(",");
                String sId =  tokens[0];
                if (!sId.matches("[0-9]+")) {
                    System.err.printf("%s es un id no válido, no se registra%n", sId);
                    continue;
                }
                int id  = Integer.parseInt(sId);
                String firstName = tokens[1];
                String lastName  = tokens[2];
                String gender    = tokens[4];
                String email     = tokens[3];
                String ipAddress = tokens[5];
                Person person = null;
                try {
                    person = new Person(id, firstName, lastName, email, gender, ipAddress);
                } catch (EmailException e) {
                    System.err.println(e.getMessage() + ": " + email);
                    continue;
                    //throw new RuntimeException(e);
                }
                people.add(person);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return people;
    }

}
