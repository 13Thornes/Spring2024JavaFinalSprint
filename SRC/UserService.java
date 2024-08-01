import java.sql.SQLException;


public class UserService {
    UserDAO userDAO = new UserDAO();

    public UserService(){
        userDAO = new UserDAO();
    }

    public boolean registerUser(User user) throws SQLException{
        if(user.equals(null)){
            System.out.println("User Is Null");
            return false;
        }
    
        userDAO.addUser(user);
        System.out.println("User Created");


        return true;
}
}
