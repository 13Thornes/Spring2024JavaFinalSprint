import java.sql.SQLException;
import java.util.ArrayList;

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


    public Admin getAdmin(User user) throws SQLException{
       
        Admin admin = adminDAO.getAdmin(user);
        return admin;
    }

    public void deleteAdminByID(String username) throws SQLException{

        adminDAO.deleteAdminBYUsernamer( username);
        System.out.println("Admin Deleted");   
    }

     public ArrayList<User> getAllUser() throws SQLException{
        ArrayList<User>users = adminDAO.getAllUsers();
        return users;
    }
}


