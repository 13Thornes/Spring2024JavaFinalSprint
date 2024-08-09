// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.util.ArrayList;
import java.util.List;


/**
 * @author Samantha Thorne
 * @version 1.00
 */
public class Seller extends User {

    // initialize variables
    /**
      * represents the id of the seller
      */
    private int sellerID;
    /**
      * represents the street address of the seller
      */
    private String stAdd;
    /**
      * represents the city of the seller
      */
    private String city;
    /**
      * represents the province of the seller
      */
    private String prov;
    /**
      * represents the postal code of the seller
      */
    private String postalCode;
    /**
      * represents a list of theseller's products
      */
    private List<Product> products;

    // Constructor
      /**
     * 
     * @param username Accepts the username of the seller and set it to the Seller object
     * @param password Accepts the password of the seller and set it to the Seller object
     * * @param firstName Accepts the first name of the seller and set it to the Seller object
     * * @param lastName Accepts the last name of the seller and set it to the Seller  object
     * * @param email Accepts the email of the seller and set it to the Seller object
     * * @param phoneNumber Accepts the phone number of the seller and sets it to the Seller object
     * * @param type Accepts the type of seller and sets it to the Seller object
     * * @param sellerID Accepts the sellerID of the seller and sets it to the Seller object
    * * @param stAdd Accepts the street address of seller and sets it to the Seller object
    * * @param city Accepts the city of seller and sets it to the Seller object
    * * @param prov Accepts the province of seller and sets it to the Seller object
    * * @param postalCode Accepts the postal code of seller and sets it to the Seller object
     */
    public Seller(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type,
                  int sellerID, String stAdd, String city, String prov, String postalCode) {
        super(username, password, firstName, lastName, email, phoneNumber, type);
        this.sellerID = sellerID;
        this.stAdd = stAdd;
        this.city = city;
        this.prov = prov;
        this.postalCode = postalCode;
        this.products = new ArrayList<>();
    }

    // Getters and Setters
    /**
     * 
     * @return returns the seller's sellerID
     */
    public int getSellerID() {
        return sellerID;
    }
    /**
     * 
     * @param buyerID accepts the sellerID of the seller and set it to the Seller object
     */
    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    /**
     * 
     * @return returns the seller's street address
     */
    public String getStAdd() {
        return stAdd;
    }
    /**
     * 
     * @param stAdd accepts the street address of the seller and set it to the seller object
     */
    public void setStAdd(String stAdd) {
        this.stAdd = stAdd;
    }


    /**
     * 
     * @return returns the seller's city
     */
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city accepts the city of the seller and set it to the seller object
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return returns the seller's province
     */
    public String getProv() {
        return prov;
    }

     /**
     * 
     * @param prov accepts the province of the seller and set it to the seller object
     */
    public void setProv(String prov) {
        this.prov = prov;
    }


    /**
     * 
     * @return returns the seller's postal code
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode accepts the postal code of the seller and set it to the seller object
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Product management methods
    /**
     * Allows you to view all of a seller's products
     * @return returns the list of seller products
     */
    public List<Product> viewSellerProducts() {
        return new ArrayList<>(products);
    }

    /**
     * Allows you to add a product to seller's products
     * @param product represents the product you would like to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Allows you to update a product in seller's products
     * @param product represents the product you would like to add
     */
    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == product.getProductID()) {
                products.set(i, product);
                return;
            }
        }
    }

    /**
     * Allows you to delete a product from seller's products
     * @param product represents the product you would like to delete
     */
    public void deleteProduct(Product product) {
        products.removeIf(p -> p.getProductID() == product.getProductID());
    }

    // toString() 
    /**
     * @return Returns all the data in the Seller object as a string
     */
    @Override
    public String toString() {
        return ( super.toString() + "Seller{" +
                "sellerID=" + sellerID +
                ", stAdd='" + stAdd + '\'' +
                ", city='" + city + '\'' +
                ", prov='" + prov + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}');
    }
    
}
