// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

/**
 * @author Samantha Thorne
 * @version 1.00
 */
public class User {
    // initialize variables
     /**
      * represents the username of the user
      */
    private String username;
    /**
      * represents the password of the user
      */
    private String password;
    /**
      * represents the first name of the user
      */
    private String firstName;
    /**
      * represents the last name of the user
      */
    private String lastName;
    /**
      * represents the email of the user
      */
    private String email;
    /**
      * represents the phone number of the user
      */
    private String phoneNumber;
    /**
      * represents the type of user
      */
    private String type;


    
    // Constructor
    /**
     * 
     * @param username Accepts the username of the user and set it to the User object
     * @param password Accepts the password of the user and set it to the User object
     * * @param firstName Accepts the first name of the user and set it to the User object
     * * @param lastName Accepts the last name of the user and set it to the User object
     * * @param email Accepts the email of the user and set it to the User object
     * * @param phoneNumber Accepts the phone number of the user and sets it to the User object
     * * @param type Accepts the type of user and sets it to the User object
     */
    public User(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public User() {
        
    }

    
    // Getters and Setters
     /**
     * 
     * @return returns the user's username
     */
    public String getUsername() {
        return username;
    }

     /**
     * 
     * @param username accepts the username of the user and set it to the User object
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * 
     * @return returns the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password accepts the password of the user and set it to the User object
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * 
     * @return returns the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName accepts the first name of the user and set it to the User object
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * 
     * @return returns the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName accepts the last name of the user and set it to the User object
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * 
     * @return returns the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email accepts the email of the user and set it to the User object
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * 
     * @return returns the user's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber accepts the phone number of the user and set it to the User object
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 
     * @return returns the user's type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type accepts the type of user and set it to the User object
     */
    public void setType(String type) {
        this.type = type;
    }

    // toString method
    /**
     * @return Returns all the data in the User object as a string
     */
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' 
                ;
    }

    
}