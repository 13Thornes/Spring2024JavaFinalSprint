import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;


public class BuyerService {
    BuyerDAO buyerDAO = new BuyerDAO();

    public BuyerService(){
        buyerDAO = new BuyerDAO();
    }

     public boolean registerBuyer(Buyer buyer) throws SQLException{
        if(buyer.equals(null)){
            System.out.println("Buyer Is Null");
            return false;
        }

        buyerDAO.addBuyer(buyer);
        System.out.println("Buyer Created");


        return true;
}

public int getbuyerID(String username) throws SQLException{
       
        int id = buyerDAO.getBuyerID(username);
        return id;
    }
}
