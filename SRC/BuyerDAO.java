// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Samantha Thorne
 * @version 1.00
 */
public class BuyerDAO {

    /**
     * Adds a buyer to the database
     * @param buyer represents the buyer object added
     * @throws SQLException when adding a buyer is unsuccessful
     */
     public void addBuyer(Buyer buyer) throws SQLException{
        String sql = "INSERT INTO \"Buyer\" (\"Username\", \"St_Add\", \"City\", \"Prov\", \"Postal_Code\") VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            
            preparedStatement.setString(1, buyer.getUsername());
            preparedStatement.setString(2, buyer.getStAdd());
            preparedStatement.setString(3, buyer.getFirstName());
            preparedStatement.setString(4, buyer.getProv());
            preparedStatement.setString(5, buyer.getPostalCode());

            preparedStatement.executeUpdate();


            
        }
    }

    /**
     * Retrieves buyerID from the database
     * @param username searches for the username in the database
     * @return the buyer Id associated with that username
     * @throws SQLException if searching for the buyer is unsuccessful
     */
    public int getBuyerID(String username) throws SQLException {
        String sql = "SELECT * FROM \"Buyer\" WHERE \"Username\" = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    return rs.getInt("Buyer_ID");
                }
            }
        }
        return 0;    
    }

    /**
     * Gets a buyer by searching for a matching user
     * @param user is the user we search for in the buyer's table
     * @return the buyer from the buyer's table
     * @throws SQLException when retrieving the buyer is unsuccessful
     */
    public Buyer getBuyer(User user) throws SQLException {
        String sql = "SELECT * FROM \"Buyer\" WHERE \"Username\" = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, user.getUsername());

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    return new Buyer(
                        user.getUsername(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getType(),
                        rs.getInt("Buyer_ID"),
                        rs.getString("St_Add"),
                        rs.getString("City"),
                        rs.getString("Prov"),
                        rs.getString("Postal_Code")
                        
                    );
                }
            }
        }
        return null;    
    }
}
