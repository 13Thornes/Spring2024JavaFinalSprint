// Project: Final Sprint Java, Ecommerce
// Author: Luke Peddle, Micheal Walsh, Samantha Thorne
// Date: July 26th - August 9th 2024

// import required libraries
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Samantha Thorne
 * @version 1.00
 */

public class SellerService {
    // required variable
    SellerDAO sellerDAO = new SellerDAO();

    // constructor
    public SellerService(){
        sellerDAO = new SellerDAO();
    }

    /**
     * adds a seller to the database
     * @param seller is the seller we're adding
     * @return true if the seller is added
     * @throws SQLException if adding is unsuccessful
     */
     public boolean registerSeller(Seller seller) throws SQLException{
       
        sellerDAO.addSeller(seller);
        System.out.println("Seller Created");


        return true;
}

/**
 * gets the seller id using the username
 * @param username is how we search the database for the seller
 * @return the seller that matches the username
 * @throws SQLException if the search is unsuccessful
 */
public int getSellerrID(String username) throws SQLException{
       
        int id = sellerDAO.getSellerID(username);
        return id;
    }

    /**
     * Get seller that matches a user
     * @param user is how we search for the seller
     * @return the seller that ,atches the user
     * @throws SQLException if the search is unsuccessful
     */
    public Seller getSeller(User user) throws SQLException{
       
        Seller seller = sellerDAO.getSeller(user);
        return seller;
    }

    
}
