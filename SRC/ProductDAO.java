import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

    public void addProduct(Product product) throws SQLException{
        String sql = "INSERT INTO \"Product\" (\"Product_Name\", \"Price\", \"QTY\", \"Description\", \"Seller_ID\") VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            
            
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQty());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getSellerID());

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


public Product getProduct(String productName) throws SQLException {
    String sql = "SELECT * FROM \"Product\" WHERE \"Product_Name\" = ?";
    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1, productName);

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

public ArrayList<Product> getSellerProducts(int sellerID) throws SQLException {
    String sql = "SELECT * FROM \"Product\" WHERE \"Seller_ID\" = ?";
    ArrayList<Product> product = new ArrayList<Product>();
    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, sellerID);

        try (ResultSet rs = preparedStatement.executeQuery()){
            while (rs.next()) {
                product.add( new Product(
                    rs.getInt("Product_ID"),
                    rs.getString("Product_Name"),
                    rs.getDouble("Price"),
                    rs.getInt("QTY"),
                    rs.getString("Description"),
                    rs.getInt("Seller_ID")
                ));
            }
        }
    }
    return product;    
}

public ArrayList<Product> getAllProducts() throws SQLException {
    String sql = "SELECT * FROM \"Product\"";
    ArrayList<Product> product = new ArrayList<Product>();
    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);


        try (ResultSet rs = preparedStatement.executeQuery()){
            while (rs.next()) {
                product.add( new Product(
                    rs.getInt("Product_ID"),
                    rs.getString("Product_Name"),
                    rs.getDouble("Price"),
                    rs.getInt("QTY"),
                    rs.getString("Description"),
                    rs.getInt("Seller_ID")
                ));
            }
        }
    }
    return product;    
}
}




