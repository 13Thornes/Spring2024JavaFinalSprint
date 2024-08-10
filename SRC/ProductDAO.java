// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Samantha Thorne
 * @version 1.00
 */
public class ProductDAO {

    /**
     * Adds a product to the database
     * @param product represents the product we're adding
     * @throws SQLException if adding to the database is unsuccessful
     */
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

/**
 * Gets the product ID from the product database
 * @param productName is what we search the product database for
 * @return the product ID associated with the product name
 * @throws SQLException if retrieving the ID is unsuccessful
 */
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

/**
 * Gets a singular product from the database
 * @param productName represents the product we're searching for
 * @return the product that matches the product name
 * @throws SQLException if we can;t retrieve the product
 */
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


public String getSellerUsername(int sellerID) throws SQLException{
    String sql = "SELECT * FROM \"Seller\" WHERE \"Seller_ID\" = ?";
    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, sellerID);


try (ResultSet rs = preparedStatement.executeQuery()){
    while (rs.next()) {
      return rs.getString("Username");
    }
}

return null;    
}
}


/**
 * Retrieves a list of products belonging to one seller
 * @param sellerID searches the product list for products that match the seller ID
 * @return the list of broducts belonging to that seller
 * @throws SQLException is retriving the list is unsuccessful
 */

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

public void deleteSellerProducts(int sellerID) throws SQLException {
    String sql = "DELETE FROM  \"Product\" WHERE \"Seller_ID\" = ?";

    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, sellerID);
        preparedStatement.executeUpdate();
    }
    catch(SQLException e){
        System.out.println(e);
    }
}

/**
 * Get all products from the product table
 * @return all the products
 * @throws SQLException if returning the list is unsuccessful
 */
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

/**
 * Updates a product's information
 * @param productName represents how we will search for a product to update
 * @param product is the new product that will replace it
 */
public  void updateProduct(String productName, Product product){
    String sql = "UPDATE  \"Product\" SET \"Product_Name\" = ?, \"Price\" = ?, \"QTY\" = ?, \"Description\" = ? WHERE \"Product_Name\" = ?";

    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(5, productName);

        
        
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQty());
        preparedStatement.setString(4, product.getDescription());

        preparedStatement.executeUpdate();
    

    }
    catch(SQLException e){
        System.out.println(e);
    }
}

/**
 * deletes a product from the database
 * @param productName represents the name of the product that we'll delete
 */
public void deleteProduct(String productName){
    String sql = "Delete FROM  \"Product\" Where  \"Product_Name\" = ?";

    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, productName);
        preparedStatement.executeUpdate();
    

    }
    catch(SQLException e){
        System.out.println(e);
    }
}

public  void deleateProductBySellerID(int sellerID){
    String sql = "Delete FROM  \"Product\" Where  \"Seller_ID\" = ?";

    try(Connection conn = DatabaseConnection.getConnection()){
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, sellerID);
        preparedStatement.executeUpdate();
    

    }
    catch(SQLException e){
        System.out.println(e);
    }
}
}




