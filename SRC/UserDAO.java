import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public void addUser(User user) throws SQLException{
        String sql = "INSERT INTO \"User\" (\"Username\", \"Password\", \"First_Name\", \"Last_Name\", \"Email\", \"Phone_Number\", \"Type\") VALUES (?, ?, ?, ?, ?, ?,?)";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getType());

            preparedStatement.executeUpdate();


            
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM \"User\" WHERE \"Username\" = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    return new User(
                            rs.getString("Username"),
                            rs.getString("Password"),
                            rs.getString("First_Name"),
                            rs.getString("Last_Name"),
                            rs.getString("Email"),
                            rs.getString("Phone_Number"),
                            rs.getString("Type")
                    );
                }
            }
        }
        return null;    
    }

    public Boolean validateUsername(String username) throws SQLException {
        String sql = "SELECT * FROM \"User\" WHERE \"Username\" = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    System.out.println("Username already exist-Please try another one");
                    return false;
                
                }
            }
        }
        return true;    
    }
}
