import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class demo {
    private static UserService userService = new UserService();
    private static BuyerService buyerService = new BuyerService();
    private static SellerService sellerService = new SellerService();
    private static AdminService adminService = new AdminService();
    Seller curSeller;
    Admin curAdmin;
    Buyer curBuyer;
    public static boolean register(ArrayList <User> users){
        boolean valid = false;
        String username = "";
        String password = "";
        String email = "";
        String phoneNumber = "";
        String type = "";
        Scanner scanner = new Scanner(System.in);
        
        while(valid == false){
            System.out.println("Enter the username");
            username = scanner.next();
            if(username.equals("")){
                System.out.println("Please enter a username");
            }

            else if(username.equals("-1")){
                return false;
            }
            else{
                valid = true;
                for(User user: users){
                    if(username.equals(user.getUsername())){
                        System.out.println("Username alread exists, please enter a different one");
                        valid = false;
                    }
                }

                
            }
        }

        valid = false;

        
        System.out.println("Enter the password");
        password = scanner.next();

        System.out.println("Enter Your first name");
        String fName = scanner.next();

        if(fName.equals("-1")){
            return false;
        }

        System.out.println("Enter your last name");
        String lName = scanner.next();
        if(lName.equals("-1")){
            return false;
        }


        while(valid == false){
            System.out.println("Enter your email");
            email = scanner.next();

            if(email.contains("@") == false){
                System.out.println("Invalid email, Please re-enter");
            }
            else if (email.equals("-1")){
                return false;
            }

            else{
                valid = true;
            }
        }

        valid = false;

        while (valid == false){
             phoneNumber = "";
            while(valid == false){
                System.out.println("Please enter your phone number");

                phoneNumber = scanner.next();

                try{
                    int check = Integer.valueOf(phoneNumber);
                    valid = true;
                }
                catch(NumberFormatException e) {
                    System.out.println("Phone number can only contain number, Please re-enter");
                }
            }
            valid = false;
            if(phoneNumber.length()!= 10){
                System.out.println("Phone number must contain 10 numbers, Please re-enter");
            }
            else{
                valid = true;
            }

            
        }

        valid = false;
        while (valid == false){
            System.out.println("Enter the type of account");
            type = scanner.next();

            if(type.equals("B") != false && type.equals("S") && type.equals("A")){
                System.out.println("Type must be B, S, or A, Please re-enter");
            }
            else{
                valid = true;
            }
        }
        
        if(type.equals("B"))
        {
            Boolean back = regBuyer(username, password, fName, lName, email, phoneNumber, type);
            if (back == true){
                return false;
            }
        }
        else if(type.equals("S"))
        {
            Boolean back = regSeller(username, password, fName, lName, email, phoneNumber, type);
            if (back == true){
                return false;
            }
        }

        else if(type.equals("A"))
        {
            Boolean back = regAdmin(username, password, fName, lName, email, phoneNumber, type);
            if (back == true){
                return false;
            }
        }
        return true;
        
    }

    public static boolean regBuyer(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type){
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        String prov = "";
        String postalCode = "";

        System.out.println("Enter the street address");
        String stAdd = scanner.next();

        if(stAdd.equals("-1")){
            return true;
        }

        System.out.println("Enter the city");
        String city = scanner.next();

        if(city.equals("-1")){
            return true;
        }

        while(valid == false){
        System.out.println("Enter the provice");
        prov = scanner.next();

        if(prov.length() !=2){
            System.out.println("Provice must be 2 charcters long- Please re-enter");
        }
        else if (prov.equals("-1")){
            return true;
        }
        else{
            valid = true;
        }
        }

        valid = false;

        while (valid == false){
            System.out.println("Please enter the postal code");
            postalCode = scanner.next();

            if(postalCode.length() != 6){
                System.out.println("Postal code must be 6 characters long-Please re-enter");
            }
            else if(postalCode.equals("-1")){
                return true;
            }
            else{
                valid = true;
            }
        }

        Buyer user = new Buyer(username, password, firstName, lastName, email, phoneNumber, type, 1, stAdd, city, prov, postalCode);
        try{
        userService.registerUser(user);
        buyerService.registerBuyer(user);
        user.setBuyerID(buyerService.getbuyerID(username));
        System.out.println(user.getBuyerID());
        }
        catch(SQLException e){
            System.out.println(e);
            return true;
        }

        
        return false;
    }

    public static boolean regSeller(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type){
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        String prov = "";
        String postalCode = "";

        System.out.println("Enter the street address");
        String stAdd = scanner.next();

        if(stAdd.equals("-1")){
            return true;
        }

        System.out.println("Enter the city");
        String city = scanner.next();

        if(city.equals("-1")){
            return true;
        }

        while(valid == false){
        System.out.println("Enter the provice");
        prov = scanner.next();

        if(prov.length() !=2){
            System.out.println("Provice must be 2 charcters long- Please re-enter");
        }
        else if (prov.equals("-1")){
            return true;
        }
        else{
            valid = true;
        }
        }

        valid = false;

        while (valid == false){
            System.out.println("Please enter the postal code");
            postalCode = scanner.next();

            if(postalCode.length() != 6){
                System.out.println("Postal code must be 6 characters long-Please re-enter");
            }
            else if(postalCode.equals("-1")){
                return true;
            }
            else{
                valid = true;
            }
        }

        Seller user = new Seller(username, password, firstName, lastName, email, phoneNumber, type, 1, stAdd, city, prov, postalCode);
        try{
            userService.registerUser(user);
            sellerService.registerSeller(user);
        user.setSellerID(sellerService.getSellerrID(username));
        System.out.println(user.getSellerID());
        }
        catch(SQLException e){
            System.out.println(e);
            return true;
        }

        
        return false;
    }

    public static boolean regAdmin(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Admin postion");
        String postion = scanner.next();

        if(postion.equals("-1")){
            return false;
        }

        Admin user = new Admin(username, password, firstName, lastName, email, phoneNumber, type, 0, postion);

        try{
            userService.registerUser(user);
            adminService.registerAdmin(user);
        user.setAdminID(adminService.getAdminID(username));
        System.out.println(user.getAdminID());
        }
        catch(SQLException e){
            System.out.println(e);
            return true;
        }

        return false;
    }
public static void main(String[] args) {
    boolean valid = false;
    Scanner scanner = new Scanner(System.in);
    ArrayList <User> users = new ArrayList<User>();

    Product p1 = new Product(1, "Ball", 4.99, 10, "A red bouncy ball", 4);
    Product p2 = new Product(2, "Frisbee", 5.99, 15, "A yellow flying disk", 5);
    Buyer b1 = new Buyer("Johnny123", "Play456", "John", "Doe", "jdoe@mail.com", "1234567890", "Buyer", 1, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    users.add(b1);
    Buyer b2 = new Buyer("Sammy648", "Play456", "Sam", "Doe", "sdoe@mail.com", "567823", "Buyer", 2, "123 Main st", "Corner Brook", "NL", "A2H 5L1");
    users.add(b2);

    Admin a1 = new Admin("Jack903", "Play456", "Jack", "Doe", "jadoe@mail.com", "0987654321", "Admin", 1, "tester" );
    users.add(a1);

    while (valid == false){
   System.out.println("Do you want to register or login");
   String option = scanner.next();
   
    
   if(option.equals("R")){
    System.out.println("Register");
    valid = register(users);
   }

   else if(option.equals("L")){
    System.out.println("Login");
   }

   else{
    System.out.println("Invalid input, Please re-enter");
   }
}

}    
}
