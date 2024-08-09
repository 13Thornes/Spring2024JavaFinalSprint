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

public class BuyerService {
    // required variable
    BuyerDAO buyerDAO = new BuyerDAO();

    // constructor
    public BuyerService(){
        buyerDAO = new BuyerDAO();
    }

    /**
     * Adds a buyer to the database
     * @param buyer represents the buyer we're adding
     * @return true if buyer is added
     * @throws SQLException if registration is unsuccessful
     */
     public boolean registerBuyer(Buyer buyer) throws SQLException{

        buyerDAO.addBuyer(buyer);
        System.out.println("Buyer Created");


        return true;
}

/**
 *  Gets buyer if from database using the username
 * @param username represents what we search for in the database
 * @return the buyer ID associated with that username
 * @throws SQLException if retrieving buyer ID is unsuccessful
 */
public int getbuyerID(String username) throws SQLException{
       
        int id = buyerDAO.getBuyerID(username);
        return id;
    }
    public Buyer getBuyer(User user) throws SQLException{
       
        Buyer buyer = buyerDAO.getBuyer(user);
        return buyer;
    }
}
