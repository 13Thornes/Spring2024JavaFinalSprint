import java.sql.SQLException;


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
    public Product getProduct(Product Product) throws SQLException{
       
        Product product = productDAO.getProduct(Product);
        return product;
    }
}