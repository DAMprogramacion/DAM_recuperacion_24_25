package RA9_9.conexion;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//patrón Singleton
public class Conexion {
    private static Conexion conexion;
    private Connection connection;

    private Conexion() {
        String url = "jdbc:sqlite:database/users.db";
        SQLiteConfig config = new SQLiteConfig();
        config.enforceForeignKeys(true);
        try {
            connection = DriverManager.getConnection(url, config.toProperties());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Conexion getInstance() {
        if (conexion == null)
            conexion = new Conexion();
        return conexion;
    }

    public Connection getConnection() {
        return connection;
    }
}
