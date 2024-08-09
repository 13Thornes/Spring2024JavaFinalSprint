// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Samantha Thorne
 * @version 1.00
 */
public class ProductService {
    // required variable
    ProductDAO productDAO = new ProductDAO();

    // constructor
    public ProductService(){
        productDAO = new ProductDAO();
    }

    /**
     * registers a product to the database
     * @param product represents the product we're adding
     * @return true if variable is added
     * @throws SQLException if registration is unsuccessful
     */
     public boolean registerProduct(Product product) throws SQLException{

        productDAO.addProduct(product);
        System.out.println("Product Created");


        return true;
}

/**
 * Retrieves the product id from the database
 * @param productID is how we search for the product
 * @return the product id
 * @throws SQLException if retrieving the productID is unsuccessful
 */
public int getProductID(String productID) throws SQLException{
       
        int id = productDAO.getProductID(productID);
        return id;
    }

    /**
     * Gets a product from the database
     * @param productName represents the name of the product we search for
     * @return the product that matches the product name
     * @throws SQLException if retrieval is unsuccessful
     */
    public Product getProduct(String productName) throws SQLException{
       
        Product product = productDAO.getProduct(productName);
        return product;
    }

    /**
     * Gets all products from the database
     * @return a list of all the products
     * @throws SQLException if products cannot be retrieved
     */
    public ArrayList<Product> getAllProduct() throws SQLException{
       
        ArrayList<Product>products = productDAO.getAllProducts();
        return products;
    }

    /**
     * Gets all products belonging to one seller
     * @param sellerID is how we search for the seller's products
     * @return the products that match the seller's ID
     * @throws SQLException if retrieval is unsuccessful
     */
    public ArrayList<Product> getSellerProduct(int sellerID) throws SQLException{
       
        ArrayList<Product>products = productDAO.getSellerProducts(sellerID);
        return products;
    }

    /**
     * Allows a product to be updated in the database
     * @param product is the new product data
     * @param productName is how we search for the product we want to update
     * @throws SQLException if product isn't updated
     */
    public void updateProduct(Product product, String productName) throws SQLException{

        productDAO.updateProduct( productName, product);
        System.out.println("Product Updated");   
}
    /**
     * Deletes a product from the database
     * @param productName represents the product we want to delete
     * @throws SQLException if deletion is unsuccessful
     */
    public void deleteProduct(String productName) throws SQLException{

    productDAO.deleateProduct( productName);
    System.out.println("Product Deleted");   
}
}