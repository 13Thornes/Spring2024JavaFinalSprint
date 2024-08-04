import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;



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
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String userPass = user.getPassword();
        user.setPassword(hashedPassword);
        userDAO.addUser(user);
        user.setPassword(userPass);
        System.out.println("User Created");


        return true;
}
}
