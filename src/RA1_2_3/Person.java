package RA1_2_3;

import java.util.Objects;

//id,firstName,lastName,email,gender,ipAddress
public class Person {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String gender;
    private final String ipAddress;
    public Person(int id, String firstName, String lastName, String email, String gender, String ipAddress)
            throws EmailException, IPAddressException {
        if (Helper.checkEmail(email))
            this.email = email;
        else
            throw new EmailException("no validate email");
        this.id = id;
        if (Helper.checkIP(ipAddress))
            this.ipAddress = ipAddress;
        else
            throw new IPAddressException("no valide IP");
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;


    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    @Override
    //4,Katleen,Dwerryhouse,kdwerryhouse3@ifeng.com,Female,37.55.78.195
    //4. Dwerryhouse Katleen, Female : kdwerryhouse3@ifeng.com. IP: 37.55.78.195
    public String toString() {
        return String.format("%d. %S %s, %s : %s. IP: %s",
                id, firstName, lastName, gender, ipAddress);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
