import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SellerService {
    SellerDAO sellerDAO = new SellerDAO();

    public SellerService(){
        sellerDAO = new SellerDAO();
    }

     public boolean registerSeller(Seller seller) throws SQLException{
       
        sellerDAO.addSeller(seller);
        System.out.println("Seller Created");


        return true;
}

public int getSellerrID(String username) throws SQLException{
       
        int id = sellerDAO.getSellerID(username);
        return id;
    }

    public Seller getSeller(User user) throws SQLException{
       
        Seller seller = sellerDAO.getSeller(user);
        return seller;
    }

    
}
