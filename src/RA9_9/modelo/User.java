package RA9_9.modelo;

import java.util.Objects;

/*
id INT,
        first_name VARCHAR(50),
        last_name VARCHAR(50),
        email VARCHAR(50)

 */
public class User {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;

    public User(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%s,%s", id, firstName, lastName, email);
    }
}
