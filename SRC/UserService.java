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
        user.setPassword(hashedPassword);
        userDAO.addUser(user);
        System.out.println("User Created");


        return true;
}

public User getUserByUsername(String username) throws SQLException{
    User user = userDAO.getUserByUsername(username);
    return user;
}

public User authUser(String username,String password) throws SQLException{
    if(username == null || password == null){
        System.out.println("The User Does Not Exist");
    }

    User user = userDAO.getUserByUsername(username);

    if(user == null){
        System.out.println("The User Does Not Exist! ");
        return null;
    }

    if(!BCrypt.checkpw(password, user.getPassword())){
        System.out.println("Wrong Password, Please Try Again!");
        return null;
    }
    return user;
}

public boolean validateUsername(String username){

    try{
    return userDAO.validateUsername(username);
    }
    catch(SQLException e){
        return false;
    }
}

public User getUser(String username) throws SQLException {
    if(username == null){
        System.out.println("The User Does Not Exist");
    }
    User user = userDAO.getUserByUsername(username);
    return user;
}

public void deleteUser(String username) throws SQLException{
    userDAO.deleteUser(username);
}
}
