import java.sql.SQLException;
import java.util.ArrayList;
public class demo {
    
public static void main(String[] args) {
    UserService UserService = new UserService();
    ArrayList <User> users = new ArrayList<User>();

    Product p1 = new Product(1, "Ball", 4.99, 10, "A red bouncy ball", 1);
    Product p2 = new Product(2, "Frisbee", 5.99, 15, "A yellow flying disk", 2);
    Product p3 = new Product(3, "Bell", 3.99, 15, "A Bell", 1);
    Buyer b1 = new Buyer("Johnny123", "Play456", "John", "Doe", "jdoe@mail.com", "1234567890", "Buyer", 1, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    users.add(b1);
    Buyer b2 = new Buyer("Sammy648", "Play456", "Sam", "Doe", "sdoe@mail.com", "567823", "Buyer", 2, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    users.add(b2);

    Seller s = new Seller("Billy356", "Play456", "Billy", "Doe", "bdoe@mail.com", "1234567890", "S", 1, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    Seller s2 = new Seller("Billy356", "Play456", "Jack", "Doe", "bdoe@mail.com", "1234567890", "S", 2, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    s.addProduct(p2);
    s2.addProduct(p1);
    s2.addProduct(p3);
   ArrayList <Seller> sellers = new ArrayList<Seller>();
   sellers.add(s2);
   sellers.add(s);
    ArrayList<Product> products = new ArrayList <Product>();
    products.add(p1);
    products.add(p2);
    products.add(p3);

    Admin a1 = new Admin("Jack903", "Play456", "Jack", "Doe", "jadoe@mail.com", "0987654321", "Admin", 1, "tester" );
    users.add(a1);
    a1.veiwProducts(sellers, products);
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
    //a1.deleteUser(users, "Sammy648");
    //a1.veiwUsers(users);
    

    //b1.addProduct(p1);
    //b1.addProduct(p2);
    // b1.viewProducts();
    //b1.viewProduct("Ball");

}    
}
