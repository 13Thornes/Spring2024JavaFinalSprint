import java.sql.SQLException;
import java.util.ArrayList;


public class ProductService {
    ProductDAO productDAO = new ProductDAO();

    public ProductService(){
        productDAO = new ProductDAO();
    }

     public boolean registerProduct(Product product) throws SQLException{

        productDAO.addProduct(product);
        System.out.println("Product Created");


        return true;
}

public int getProductID(String productID) throws SQLException{
       
        int id = productDAO.getProductID(productID);
        return id;
    }
    public Product getProduct(String productName) throws SQLException{
       
        Product product = productDAO.getProduct(productName);
        return product;
    }

    public ArrayList<Product> getAllProduct() throws SQLException{
       
        ArrayList<Product>products = productDAO.getAllProducts();
        return products;
    }

    public ArrayList<Product> getSellerProduct(int sellerID) throws SQLException{
       
        ArrayList<Product>products = productDAO.getSellerProducts(sellerID);
        return products;
    }

    public void updateProduct(Product product, String productName) throws SQLException{

        productDAO.updateProduct( productName, product);
        System.out.println("Product Updated");   
}

    public void deleteProduct(String productName) throws SQLException{

    productDAO.deleateProduct( productName);
    System.out.println("Product Deleted");   
}

public void deleteProductBySellerID(int sellerID) throws SQLException{

    productDAO.deleateProductBySellerID( sellerID);
    System.out.println("Product Deleted");   
}

public String getSellerUsername(int sellerID) throws SQLException{

    return productDAO.getSellerUsername( sellerID);
       
}
}