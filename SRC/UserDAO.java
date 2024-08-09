// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Samantha Thorne
 * @version 1.00
 */

public class UserDAO {

    /**
     * Adds a user to the database
     * @param user is the user we're adding
     * @throws SQLException if adding is unsuccessful
     */
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

    /**
     * Gets the user by it's username
     * @param username is how we search for the user
     * @return the user that matches the username
     * @throws SQLException if the search is unsuccessful
     */
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

    /**
     * validates a username is in the database
     * @param username is the username we're searching for
     * @return true if username is valid
     * @throws SQLException if username is invalid
     */
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
