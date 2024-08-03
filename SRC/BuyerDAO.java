import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyerDAO {
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
}
