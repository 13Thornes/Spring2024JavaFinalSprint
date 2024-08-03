import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerDAO {


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
}


