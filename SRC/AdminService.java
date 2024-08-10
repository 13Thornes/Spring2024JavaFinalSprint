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


public class AdminService {

    // required variable
    AdminDAO adminDAO = new AdminDAO();

    // Constructor
    public AdminService(){
        adminDAO = new AdminDAO();
    }

    /**
     * Creates an admin in the database
     * @param admin represents the admin object that we're creating
     * @return the boolean true that admin was registered
     * @throws SQLException when registering an admin was unsuccessful
     */
     public boolean registerAdmin(Admin admin) throws SQLException{

        adminDAO.addAdmin(admin);
        System.out.println("Admin Created");


        return true;
}

/**
 * Retrieves the admin ID from an admin in the database
 * @param username represents the username we're trying to search in the admin table
 * @return the admin ID of the specified admin
 * @throws SQLException if retriving the username is unsuccessful
 */
public int getAdminID(String username) throws SQLException{
       
        int id = adminDAO.getAdminID(username);
        return id;
    }

/**
 * Searched the admin database for an admin that matches the specified user
 * @param user represents the user we're trying to search
 * @return the admin we're searching for
 * @throws SQLException if the search is unsuccessful
 */
    public Admin getAdmin(User user) throws SQLException{
       
        Admin admin = adminDAO.getAdmin(user);
        return admin;
    }
    
/**
 * Searches the whole database for users then lists them
 * @return ArrayList of users
 * @throws SQLException if the search is unsuccessful
 */
    public ArrayList<User> getAllUser() throws SQLException{

        ArrayList<User>users = adminDAO.getAllUsers();
        return users;
    }

    public void deleteAdminByID(String username) throws SQLException{

        adminDAO.deleteAdminBYUsernamer( username);
        System.out.println("Admin Deleted");   
    }
}


