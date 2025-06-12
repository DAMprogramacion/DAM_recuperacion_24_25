package RA9_9;

import RA9_9.conexion.Conexion;
import RA9_9.dao.UserDAO;
import RA9_9.dao.UserDAOImpl;
import RA9_9.modelo.User;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection1 = Conexion.getInstance().getConnection();
        System.out.println(connection1);
        Connection connection2 = Conexion.getInstance().getConnection();
        System.out.println(connection2);
        System.out.println("===========================");
        UserDAO dao = new UserDAOImpl();
        List<User> users = dao.getUsers();
        System.out.printf("Nº usuarios: %d%n", users.size());
        String email = "mwalkeyrr@japanpost.jp";
        User user = dao.getUserByEmail(email);
        System.out.printf("Usuario con email %s es %s, %s%n", email, user.getLastName(), user.getFirstName());
        user.setLastName("jiménez");
        dao.updateFisrtAndOrLastName(user);
        System.out.printf("Usuario con email %s es %s, %s%n", email, user.getLastName(), user.getFirstName());

    }
}
