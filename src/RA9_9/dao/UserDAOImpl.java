package RA9_9.dao;

import RA9_9.conexion.Conexion;
import RA9_9.modelo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private Connection connection;

    public UserDAOImpl() {
        connection = Conexion.getInstance().getConnection();
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = " SELECT * FROM user;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName  = resultSet.getString("last_name");
                String email  = resultSet.getString("email");
                User user = new User(id, firstName, lastName, email);
                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = null;
        String sql = " SELECT * FROM user WHERE email = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName  = resultSet.getString("last_name");
                user = new User(id, firstName, lastName, email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean insertUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String email) {
        return false;
    }

    @Override
    public void updateFisrtAndOrLastName(User user) {
        String sql = "UPDATE user SET first_name = ?, last_name = ? WHERE email = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
