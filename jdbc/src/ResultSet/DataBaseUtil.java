package ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
    public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_lesson_jon", "db_user_jon", "12345");
        } catch (ClassNotFoundException |SQLException  e) {
            throw new RuntimeException(e);
        }
    }
}
