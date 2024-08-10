// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

/**
 * @author Samantha Thorne
 * @version 1.00
 */

public class UserService {

    // required variable
    UserDAO userDAO = new UserDAO();

    // constructor
    public UserService(){
        userDAO = new UserDAO();
    }

    /**
     * Adds a user to the database
     * @param user represents the user we're adding
     * @return true if the user is created
     * @throws SQLException if creation was unsuccessfull
     */
    public boolean registerUser(User user) throws SQLException{
        if(user.equals(null)){
            System.out.println("User Is Null");
            return false;
        }

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userDAO.addUser(user);
        System.out.println("User Created");


        return true;
}


public User getUserByUsername(String username) throws SQLException{

/**
 * Deletes a user from the database
 * @param user represents the user we're deleting
 * @throws SQLException if creation was unsuccessfull
 */

public void deleteUser(String username) throws SQLException{
    userDAO.deleteUser(username);
}

/**
 * Gets a user from the database
 * @param user represents the user we're getting
 * @return user if found
 * @throws SQLException if creation was unsuccessfull
 */
public User getUser(String username) throws SQLException {
    if(username == null){
        System.out.println("The User Does Not Exist");
    }

    User user = userDAO.getUserByUsername(username);
    return user;
}



/**
 * makes sure a user is authorized
 * @param username represents the username to login
 * @param password represents the password to login
 * @return the user that matches the username and password
 * @throws SQLException if match isn't found
 */

public User authUser(String username,String password) throws SQLException{
    if(username == null || password == null){
        System.out.println("The User Does Not Exist");
    }

    User user = userDAO.getUserByUsername(username);

    if(user == null){
        System.out.println("The User Does Not Exist! ");
        return null;
    }

    if(!BCrypt.checkpw(password, user.getPassword())){
        System.out.println("Wrong Password, Please Try Again!");
        return null;
    }
    return user;
}

/**
 * Checks if the username is in the database
 * @param username is the username we're validating
 * @return username if it's valid
 */
public boolean validateUsername(String username){

    try{
    return userDAO.validateUsername(username);
    }
    catch(SQLException e){
        return false;
    }
}

public User getUser(String username) throws SQLException {
    if(username == null){
        System.out.println("The User Does Not Exist");
    }
    User user = userDAO.getUserByUsername(username);
    return user;
}

public void deleteUser(String username) throws SQLException{
    userDAO.deleteUser(username);
}
}
