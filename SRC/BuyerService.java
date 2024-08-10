import java.sql.SQLException;


public class BuyerService {
    BuyerDAO buyerDAO = new BuyerDAO();

    public BuyerService(){
        buyerDAO = new BuyerDAO();
    }

     public boolean registerBuyer(Buyer buyer) throws SQLException{

        buyerDAO.addBuyer(buyer);
        System.out.println("Buyer Created");


        return true;
}

public int getbuyerID(String username) throws SQLException{
       
        int id = buyerDAO.getBuyerID(username);
        return id;
    }
    public Buyer getBuyer(User user) throws SQLException{
       
        Buyer buyer = buyerDAO.getBuyer(user);
        return buyer;
    }

    public void deleteBuyerByID(String username) throws SQLException{

        buyerDAO.deleteBuyerByUsernamer( username);
        System.out.println("Buyer Deleted");   
    }
}
