package shared;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
    public static Connection getConnection() {
        try {
            String url = "jdbc:postgresql://localhost:5432/dbpao";
            String user = "sebi";
            String password = "1234";
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // print to csv later
            return null;
        }
    }
}