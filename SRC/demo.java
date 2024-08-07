import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class demo {
    private static UserService userService = new UserService();
    private static BuyerService buyerService = new BuyerService();
    private static SellerService sellerService = new SellerService();
    private static AdminService adminService = new AdminService();
    private static ProductService productService = new ProductService();
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
        //Go to Admin meniu
        }
        catch(SQLException e){
            System.out.println(e);
            return true;
        }

        
        return false;
    }

public static boolean login(){
    String username;
    String password;
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Enter your username");
    username = scanner.next();
    if(username.equals("-1")){
        return true;
    }

    System.out.println("Enter your password");
    password = scanner.next();

    if(password.equals("-1")){
        return true;
    }

    try{
        User user = userService.authUser(username, password);

        if(user != null){
        System.out.println(user.toString());

        if(user.getType().equals("B")){
            
            Buyer buyer = buyerService.getBuyer(user);
            System.out.println(buyer.toString());
            buyerMenu(buyer);
        }

        else if(user.getType().equals("S")){
            Seller seller = sellerService.getSeller(user);
            System.out.println(seller.toString());
            sellerMenu(seller);
        }

        else{
            Admin admin = adminService.getAdmin(user);
            System.out.println(admin.toString());
        }
        }
        else{
            return false;
        }
    }
    catch(SQLException e){
        return false;
    }

    return true;

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

public static void buyerMenu(Buyer buyer){
    Scanner scanner = new Scanner(System.in);
    boolean out = false;
    int choice = 0;

    System.out.println("Welcome " + buyer.getUsername());
    while(out == false){
    System.out.println("1: Veiw All Products\n2: Product Search\n3.Exit");
    try{
    choice = scanner.nextInt();
    }
    catch(NumberFormatException e){
        System.out.println("Input must be a number-Please renter");
    }

    switch(choice){
        case 1:
        veiwAllProducts();
        break;
        

        case 2:
        searchProduct();
        break;

        case 3:
        out = true;
        break;

        default:
        System.out.println("Invalid input");
        break;
    }
}
    


   


}

public static void veiwAllProducts(){
        ArrayList<Product>products = new ArrayList<Product>();
    try{
        products = productService.getAllProduct();

        for(Product product: products){
            System.out.println(product.toString());
            
        }
    }
    catch(SQLException e){
        System.out.println("Cannot access database");
        
    }


}

public static void searchProduct(){
    String productName;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the product Name");
    productName = scanner.next();

try{
    Product product = productService.getProduct(productName);

    if(product == null){
        System.out.println("Could not find product");

    
    }
    else{
        System.out.println(product.toString());
    }

    
}
catch(SQLException e){
    System.out.println(e);
}



}

public static void sellerMenu(Seller seller){
    System.out.println("Welcome to the Seller Menu");
        
        System.out.println("1. View Seller Products");
        System.out.println("2. Add Product");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        


        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;

        while(validInput == false){
            System.out.println("Please select option 1-4");
            choice = scanner.nextInt();
    
            if(choice >= 1 && choice < 4 ){
                validInput = true;
                

                switch (choice) {
                    case 1:
                    System.out.println("Enter veiw products");
                    try{
                    ArrayList<Product>products = productService.getSellerProduct(seller.getSellerID());

                    if(products == null){
                        System.out.println("You have no products to sell");
                    }

                    else{
                        for(Product product: products){
                            System.out.println(product.toString());
                        }
                    }
                    }
                    catch(SQLException e){
                        System.out.println(e);
                    }
                        
                    break;

                    case 2:
                    // add product
                    String productName;
                    double price;
                    int qty;
                    String description;
                    int sellerID;

                    scanner.nextLine();
                    System.out.println("Enter the product name");
                    productName = scanner.nextLine();
                    

                    System.out.println("Enter the product description");
                    
                    description = scanner.nextLine();


                    System.out.println("Enter the product price");
                    price = scanner.nextDouble();

                    
                    System.out.println("Enter the product quantity");
                    qty = scanner.nextInt();

                    
                    sellerID = seller.getSellerID();


                     Product p = new Product(0, productName, price, qty, description, sellerID);
                     try{
                     productService.registerProduct(p);
                     }
                     catch(SQLException e){
                        System.out.println("Problem with the database");
                        System.out.println(e);
                     }
                     break;

                    case 3:
                    scanner.nextLine();
                    Product product = null;
                    Boolean noError = true;
                    System.out.println("Enter the name of the product you wish to update");
                     productName = scanner.nextLine();

                     try{
                      product = productService.getProduct(productName);

                     }
                     catch(SQLException e){
                        System.out.println(e);
                        noError = false;
                     }

                     if(noError){
                        if(product == null){
                            System.out.println(productName + " does not exisit");
                        }
                        else{
                            scanner.nextLine();

                            System.out.println("Enter the product name");
                            product.setProductName(scanner.nextLine());

                            System.out.println("Enter the price");
                            product.setPrice(scanner.nextDouble());

                            System.out.println("Enter the QTY");
                            product.setQty(scanner.nextInt());

                            scanner.nextLine();
                            System.out.println("Enter the Description");
                            product.setDescription(scanner.nextLine());
                            try{
                            productService.updateProduct(product, productName);
                            }
                            catch(SQLException e){
                                System.out.println(e);
                            }
                        }
                     }
                     break;
                     case 4:
                     


                }
            }
        }
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
    valid = false;
    while(valid == false){
        valid = login();
    }
   }

   else{
    System.out.println("Invalid input, Please re-enter");
   }
}

}    
}
