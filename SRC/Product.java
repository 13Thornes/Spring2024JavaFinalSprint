// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

/**
 * @author Samantha Throne
 * @version 1.00
 */
public class Product {
    
    // initialize variables
    /**
      * represents the id of the product
      */
    int productID;
    /**
      * represents the name of the product
      */
    String productName;
    /**
      * represents the price of the product
      */
    double price;
    /**
      * represents the quantity of the product
      */
    int qty;
    /**
      * represents the description of the product
      */
    String description;
    /**
      * represents the seller id associated with the product
      */
    int sellerID;
    
/**
 * 
 * @param productID Accepts the productID of the product and sets it to the Product object
 * @param productName Accepts the productName of the product and sets it to the Product object
 * @param price Accepts the price of the product and sets it to the Product object
 * @param qty Accepts the quantity of the product and sets it to the Product object
 * @param description Accepts the description of the product and sets it to the Product object
 * @param sellerID Accepts the sellerID of the product and sets it to the Product object
 */
    public Product(int productID, String productName, double price, int qty, String description, int sellerID) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.sellerID = sellerID;
    }

    /**
     * 
     * @return returns the product's productID
     */
    public int getProductID() {
        return productID;
    }
    /**
     * 
     * @param productID accepts the productID of the product and set it to the Product object
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }


    /**
     * 
     * @return returns the product's name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 
     * @param productID accepts the name of the product and set it to the Product object
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }


    /**
     * 
     * @return returns the product's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 
     * @param price accepts the price of the product and set it to the Product object
     */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
     * 
     * @return returns the product's quantity
     */
    public int getQty() {
        return qty;
    }
    /**
     * 
     * @param qty accepts the quantity of the product and set it to the Product object
     */
    public void setQty(int qty) {
        this.qty = qty;
    }


     /**
     * 
     * @return returns the product's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description accepts the description of the product and set it to the Product object
     */
    public void setDescription(String description) {
        this.description = description;
    }


     /**
     * 
     * @return returns the product's associated sellerID
     */
    public int getSellerID() {
        return sellerID;
    }

    /**
     * 
     * @param sellerID accepts the sellerID of the product and set it to the Product object
     */
    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    // to string()
    /**
     * @return Returns all the data in the Product object as a string
     */
    public String toString() {
        return "Product [productID=" + productID + ", productName=" + productName + ", price=" + price + ", qty=" + qty
                + ", description=" + description + ", sellerID=" + sellerID + "]";
    }

    /**
     * Allows the product to be updated
     * @param productID accepts the productID of the product and set it to the Product object
     * @param productName accepts the name of the product and set it to the Product object
     * @param price accepts the price of the product and set it to the Product object
     * @param qty accepts the quantity of the product and set it to the Product object
     * @param description accepts the description of the product and set it to the Product object
     * @param sellerID accepts the quantity of the product and set it to the Product object
     */
    public void updateProduct(int productID, String productName, double price, int qty, String description, int sellerID) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.sellerID = sellerID;
    }

    


    

    
}
