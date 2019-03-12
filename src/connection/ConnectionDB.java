package connection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
    public static Connection getConnection() throws SQLException {

        Properties props = new Properties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            props.load(in);
        } catch (IOException e) {
            System.out.println("Configuration database file not found");
        }
        String url = props.getProperty("url");
        String username = props.getProperty("login");
        String password = props.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }
}
