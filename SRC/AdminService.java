import java.sql.SQLException;

public class AdminService {

    AdminDAO adminDAO = new AdminDAO();

    public AdminService(){
        adminDAO = new AdminDAO();
    }

     public boolean registerAdmin(Admin admin) throws SQLException{

        adminDAO.addAdmin(admin);
        System.out.println("Buyer Created");


        return true;
}

public int getAdminID(String username) throws SQLException{
       
        int id = adminDAO.getAdminID(username);
        return id;
    }
}


