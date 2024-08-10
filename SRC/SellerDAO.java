import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerDAO {


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

    public Seller getSeller(int sellerID) throws SQLException {
        String sql = "SELECT * FROM \"Seller\" WHERE \"Seller_ID\" = ?";
        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, sellerID);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (rs.next()) {
                    return new Seller(
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getString("Email"),
                        rs.getString("Phone_Number"),
                        rs.getString("Type"),
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

    
}


