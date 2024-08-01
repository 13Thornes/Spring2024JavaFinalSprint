import java.sql.SQLException;
import java.util.ArrayList;
public class demo {
    
public static void main(String[] args) {
    UserService UserService = new UserService();
    ArrayList <User> users = new ArrayList<User>();

    Product p1 = new Product(1, "Ball", 4.99, 10, "A red bouncy ball", 4);
    Product p2 = new Product(2, "Frisbee", 5.99, 15, "A yellow flying disk", 5);
    Buyer b1 = new Buyer("Johnny123", "Play456", "John", "Doe", "jdoe@mail.com", "1234567890", "Buyer", 1, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    users.add(b1);
    Buyer b2 = new Buyer("Sammy648", "Play456", "Sam", "Doe", "sdoe@mail.com", "567823", "Buyer", 2, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    users.add(b2);

    Admin a1 = new Admin("Jack903", "Play456", "Jack", "Doe", "jadoe@mail.com", "56789312687", "Admin", 1, "tester" );
    users.add(a1);
    for(User user: users){

        try{
        UserService.registerUser(user);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    //a1.veiwUsers(users);
    //a1.veiwUser(users);
    a1.deleteUser(users, "Sammy648");
    a1.veiwUsers(users);

    //b1.addProduct(p1);
    //b1.addProduct(p2);
    // b1.viewProducts();
    //b1.viewProduct("Ball");

}    
}
