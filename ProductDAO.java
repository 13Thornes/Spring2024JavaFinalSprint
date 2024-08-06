import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    public void addProduct(Product product) throws SQLException{
        String sql = "INSERT INTO \"Product\" (\"Product_ID\", \"Product_Name\", \"Price\", \"QTY\", \"Description\", \"Seller_ID\") VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            
            preparedStatement.setInt(1, product.getProductID());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQty());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getSellerID());

            preparedStatement.executeUpdate();
    }
}

public int getProductID(String productName) throws SQLException{ 
    String sql = "SELECT * FROM \"Product\" WHERE \"Product_Name\" = ?";
    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, productName);

        try (ResultSet rs = preparedStatement.executeQuery()){
            if (rs.next()) {
                return rs.getInt("Product_ID");
            }
        }
    }
    return 0;    
}


public Product getProduct(Product product) throws SQLException {
    String sql = "SELECT * FROM \"Product\" WHERE \"Product_Name\" = ?";
    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, product.getProductName());

        try (ResultSet rs = preparedStatement.executeQuery()){
            if (rs.next()) {
                return new Product(
                    rs.getInt("Product_ID"),
                    rs.getString("Product_Name"),
                    rs.getDouble("Price"),
                    rs.getInt("QTY"),
                    rs.getString("Description"),
                    rs.getInt("Seller_ID")
                );
            }
        }
    }
    return null;    
}
}




