// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Samantha Thorne
 * @version 1.00
 */
public class Admin extends User {

    // initialize variables
    /**
      * represents the id of the admin
      */
    private int adminID;
    /**
      * represents the psotion of the admin
      */
    private String position;
    /**
     * 
     * @param username Accepts the username of the admin and set it to the Admin object
     * @param password Accepts the password of the admin and set it to the Admin  object
     * * @param firstName Accepts the first name of the admin and set it to the Admin object
     * * @param lastName Accepts the last name of the admin and set it to the Admin  object
     * * @param email Accepts the email of the admin and set it to the Admin object
     * * @param phoneNumber Accepts the phone number of the admin and sets it to the Admin object
     * * @param type Accepts the type of user and sets it to the Admin object
     * * @param adminID Accepts the adminID of the admin and sets it to the Admin object
    * * @param position Accepts the position of admin and sets it to the Admin object
     */
    public Admin(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type, int adminID, String position){
        super(username, password, firstName, lastName, email, phoneNumber, type);
        this.adminID = adminID;
        this.position = position;
    }


    // Getters and Setters
     /**
     * 
     * @return returns the admin's adminID
     */
    public int getAdminID() {
        return adminID;
    }

    /**
     * 
     * @return returns the admin's position
     */
    public String getPosition() {
        return position;
    }

    /**
     * 
     * @param adminID accepts the adminID of the admin and set it to the Admin object
     */
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    /**
     * 
     * @param position accepts the position of the admin and set it to the Admin object
     */
    public void setPosition(String position) {
        this.position = position;
    }
    

     /**
     * View a single user from a list of users
     * @param users allows us to view a list of all users
     */
    public void veiwUser(ArrayList <User> users){
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String username;
        System.out.println("Enter the username for the account you wish to veiw: " );
        username = scanner.next();

        for (User user: users){
            if (user.getUsername().equals(username)){
                System.out.println(user.toString());
                valid = true;
            }
        }

        if(valid == false){
            System.out.println("User is not in database");
        }

    }

    /**
     * View all users from a list of users
     * @param users allows us to view a list of all users
     */
    public void veiwUsers(ArrayList <User> users){
        for (User user: users){

                System.out.println(user.toString());      
        }

    } 
    
    /**
     * Allows us to delete a user
     * @param users allows us to view a list of all users
     * @param username allows us to select which user to delete
     */
    public int deleteUser(ArrayList <User> users, String username){
        boolean valid = false;
        User reUser = new User();
        for (User user: users){
            if (user.getUsername().equals(username)){
                reUser = user;
                valid = true;
            }
        }

        if(valid == false){
            throw new NullPointerException(username + " Is not in the database");
        }
        
            users.remove(reUser);
            System.out.println("User removed");
        
            return adminID;
    }


    /**
     * Allows us to view a Seller's products
     * @param sellers allows us to view a list of all sellers
     * @param username allows us to view a list of sellers products
     */
    public void veiwProducts(ArrayList <Seller> sellers, ArrayList <Product> products){
        for(Seller seller: sellers){

                for(Product product: products){
                    if(product.getSellerID() == seller.getSellerID()){
                    System.out.println(product.getProductName() + " " + seller.getFirstName() + " " + seller.getLastName()  );
                   // System.out.println("$" + product.getPrice() + " Quanity: " + product.getQty());
                  //  System.out.println(product.getDescription());
                   // System.out.println("Contact: " + seller.getPhoneNumber() + seller.getEmail());
                    }
                }
                
        }
    }

    // toString() 
    /**
     * @return Returns all the data in the Admin object as a string
     */
    @Override
    public String toString() {
        return(super.toString() + "\n Admin{\nAdminID = " + adminID +
        "\nPosition = " + position + "\n}"); 
    }
}
