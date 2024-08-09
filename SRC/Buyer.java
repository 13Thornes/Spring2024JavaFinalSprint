// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.util.ArrayList;

/**
 * @author Samantha Thorne
 * @version 1.00
 */
public class Buyer extends User {

    // initialize variables
    /**
      * represents the id of the buyer
      */
    int buyerID;
    /**
      * represents the street address of the buyer
      */
    String stAdd;
    /**
      * represents the city of the buyer
      */
    String city;
    /**
      * represents the province of the buyer
      */
    String prov;
    /**
      * represents the postal code of the buyer
      */
    String postalCode;
    /**
      * represents a list of products the buyer can view
      */
    ArrayList<Product> productList = new ArrayList<Product>();


// Constructor
    /**
     * 
     * @param username Accepts the username of the buyer and set it to the Buyer object
     * @param password Accepts the password of the buyer and set it to the Buyer  object
     * * @param firstName Accepts the first name of the buyer and set it to the Buyer object
     * * @param lastName Accepts the last name of the buyer and set it to the Buyer  object
     * * @param email Accepts the email of the buyer and set it to the Buyer object
     * * @param phoneNumber Accepts the phone number of the buyer and sets it to the Buyer object
     * * @param type Accepts the type of buyer and sets it to the Buyer object
     * * @param buyerID Accepts the buyerID of the buyer and sets it to the Buyer object
    * * @param stAdd Accepts the street address of buyer and sets it to the Buyer object
    * * @param city Accepts the city of buyer and sets it to the Buyer object
    * * @param prov Accepts the province of buyer and sets it to the Buyer object
    * * @param postalCode Accepts the postal code of buyer and sets it to the Buyer object
     */
    public Buyer(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type, int buyerID, String stAdd, String city, String prov, String postalcode) {
        super(username, password, firstName, lastName, email, phoneNumber, type);
        this.buyerID = buyerID;
        this.stAdd = stAdd;
        this.city = city;
        this.prov = prov;
        this.postalCode = postalcode;
    }

    // Getters and Setters
     /**
     * 
     * @return returns the buyer's buyerID
     */
    public int getBuyerID() {
        return buyerID;
    }
    /**
     * 
     * @param buyerID accepts the buyerID of the buyer and set it to the Buyer object
     */
    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }


    /**
     * 
     * @return returns the buyer's street address
     */
    public String getStAdd() {
        return stAdd;
    }
    /**
     * 
     * @param stAdd accepts the street address of the buyer and set it to the Buyer object
     */
    public void setStAdd(String stAdd) {
        this.stAdd = stAdd;
    }


    /**
     * 
     * @return returns the buyer's city
     */
    public String getCity() {
        return city;
    }
    /**
     * 
     * @param city accepts the city of the buyer and set it to the Buyer object
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * 
     * @return returns the buyer's province
     */
    public String getProv() {
        return prov;
    }
    /**
     * 
     * @param prov accepts the province of the buyer and set it to the Buyer object
     */
    public void setProv(String prov) {
        this.prov = prov;
    }
    /**
     * 
     * @return returns the buyer's postal code
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * 
     * @param postalCode accepts the postal code of the buyer and set it to the Buyer object
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // toString() 
    /**
     * @return Returns all the data in the Buyer object as a string
     */
    @Override
    public String toString() {
        return (super.toString() + "Buyer [buyer_ID=" + buyerID + ", stAdd=" + stAdd + ", city=" + city + ", prov=" + prov
                + ", postalCode=" + postalCode + "]");
    }
    

    /**
     * Allows us to add a product to a buyer's product list
     * @param product represents the product we wish to add
     */
    public void addProduct(Product product) {
        if(productList.contains(product)) {
            System.out.println("Product already exists");
        } else {
            productList.add(product);
            System.out.println(product.productName + " added");
        }  
    }

     /**
     * Allows us to remove a product to a buyer's product list
     * @param product represents the product we wish to remove
     */
    public void removeProduct(Product product) {
        if(productList.contains(product)) {
            productList.remove(product);
            System.out.println(product.productName + " removed");
        } else {
            System.out.println("Product not found");
        }
    }

     /**
     * Allows us to view the products in a buyer's product list
     * @return returns the buyer's product list
     */
    public void viewProducts() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    /**
     * Allows us to view a product in a buyer's product list
     * @param productName represents the name of the product we wish to view
     */
    public void viewProduct(String productName) {
        for (Product product : productList) {
            if(product.productName.equals(productName)) {
            System.out.println(product.toString());
            }
        }
    }
    
}