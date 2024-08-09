// connecting to the postgress database
import java.sql.*;
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/ECommerce";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Luke5341";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    
}

