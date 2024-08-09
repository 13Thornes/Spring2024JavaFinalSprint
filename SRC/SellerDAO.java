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
public class SellerDAO {

    /**
     * Adds a seller to the database
     * @param seller represents the seller we want to add
     * @throws SQLException if adding the seller isn't successful
     */
     public void addSeller(Seller seller) throws SQLException{
        String sql = "INSERT INTO \"Seller\" (\"Username\", \"St_Add\", \"City\", \"Prov\", \"Postal_Code\") VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            
            preparedStatement.setString(1, seller.getUsername());
            preparedStatement.setString(2, seller.getStAdd());
            preparedStatement.setString(3, seller.getFirstName());
            preparedStatement.setString(4, seller.getProv());
            preparedStatement.setString(5, seller.getPostalCode());

            preparedStatement.executeUpdate();


            
        }
    }

    /**
     * Gets the seller ID from the database
     * @param username is how we search for the seller
     * @return the id of the seller
     * @throws SQLException if the search is unsuccessful
     */
    public int getSellerID(String username) throws SQLException {
        String sql = "SELECT * FROM \"Seller\" WHERE \"Username\" = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, username);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    return rs.getInt("Seller_ID");
                }
            }
        }
        return 0;    
    }

    /**
     * Gets a seller by searching for a matching user
     * @param user is the user we're searching for
     * @return the Seller that matches the user
     * @throws SQLException if the search is unsuccessful
     */
    public Seller getSeller(User user) throws SQLException {
        String sql = "SELECT * FROM \"Seller\" WHERE \"Username\" = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, user.getUsername());

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    return new Seller(
                        user.getUsername(),
                        user.getPassword(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getType(),
                        rs.getInt("Seller_ID"),
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


