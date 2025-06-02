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
        String gender = "Polygender";
        int numberOfPeopleMale = getNumberPeopleByGender (people, gender);
        System.out.printf("%d %s in the files%n", numberOfPeopleMale, gender);
        List<Person>[] data = getListsByIPClass(people);
        System.out.printf("Number of IP of class A: %d%n", data[0].size());
        System.out.printf("Number of IP of class B: %d%n", data[1].size());
        System.out.printf("Number of IP of class C: %d%n", data[2].size());
        System.out.printf("Number of IP of class D: %d%n", data[3].size());

    }
    private static List<Person>[] getListsByIPClass (List<Person> people) {
        List<Person>[] data = new List[4];
        List<Person> ipAddresClassA = new ArrayList<>();
        List<Person> ipAddresClassB = new ArrayList<>();
        List<Person> ipAddresClassC = new ArrayList<>();
        List<Person> ipAddresClassD = new ArrayList<>();
        data[0] = ipAddresClassA;
        data[1] = ipAddresClassB;
        data[2] = ipAddresClassC;
        data[3] = ipAddresClassD;
        for (Person person : people) {
            String[] tokens = person.getIpAddress().split("\\.");
            int byte0 = Integer.parseInt(tokens[0]);
            if (byte0 >= 0 && byte0 <= 127)
                ipAddresClassA.add(person);
            else if (byte0 > 127 && byte0 <= 191)
                ipAddresClassB.add(person);
            else if (byte0 > 191 && byte0 <= 223)
                ipAddresClassC.add(person);
            else
                ipAddresClassD.add(person);
        }
        return data;
    }
    private static int getNumberPeopleByGender(List<Person> people, String gender) {
        int count = 0;
        for (Person person : people)
            if (person.getGender().equalsIgnoreCase(gender))
                count++;
        return count;
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
                } catch (IPAddressException e) {
                    System.err.println(e.getMessage() + ": " + ipAddress);
                    continue;
                }
                people.add(person);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return people;
    }

}
