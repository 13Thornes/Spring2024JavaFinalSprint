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
        String sql = "INSERT INTO \"Seller\" (\"Username\", \"Company_Name\", \"St_Add\", \"City\", \"Prov\", \"Postal_Code\") VALUES (?, ?, ?, ?, ?,?)";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            
            preparedStatement.setString(1, seller.getUsername());
            preparedStatement.setString(2, seller.getCompanyName());
            preparedStatement.setString(3, seller.getStAdd());
            preparedStatement.setString(4, seller.getFirstName());
            preparedStatement.setString(5, seller.getProv());
            preparedStatement.setString(6, seller.getPostalCode());

            preparedStatement.executeUpdate();


            
        }
    }
    /**
     * Deletes a seller from the database
     * @param username represents the seller we want to delete
     * @throws SQLException if deleting the seller isn't successful
     */
    public void deleteSeller(String username) throws SQLException {
        String sql = "DELETE FROM  \"Seller\" WHERE \"Username\" = ?";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
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
                        rs.getString("Company_Name"),
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

    /**
     * Deletes seller by username
     * @param username is the user to be deleted
     * @throws SQLException if the search is unsuccessful
     */
    public void deleteSellerByUsernamer(String username){
        String sql = "Delete FROM  \"Seller\" Where  \"Username\" = ?";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        
    
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    /**
     * Returns true if a user is a seller
     * @param user is the user we're searching for
     * @return true if user is seller
     * @throws SQLException if the search is unsuccessful
     */
    public boolean isSeller(User user) throws SQLException {
        String sql = "SELECT COUNT(*) FROM \"Seller\" WHERE \"Username\" = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            
            preparedStatement.setString(1, user.getUsername());
            
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw e;
        }
        return false;
    }

}


