import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class demo {
    private static UserService userService = new UserService();
    private static BuyerService buyerService = new BuyerService();
    private static SellerService sellerService = new SellerService();
    private static AdminService adminService = new AdminService();
    private static ProductService productService = new ProductService();

    //Method to register
    public static boolean register(){
        boolean valid = false;
        String username = "";
        String password = "";
        String email = "";
        String phoneNumber = "";
        String type = "";
        Scanner scanner = new Scanner(System.in);
        
        //Have the user enter all the nessacry information for a user
        while(valid == false){
            System.out.println("Enter the username");
            username = scanner.next();
            if(username.equals("")){
                System.out.println("Please enter a username");
            }

            //Exit out of registry
            else if(username.equals("-1")){
                return false;
            }
            //Ensure that the username is not taken already
            else{
                valid = userService.validateUsername(username);

                
            }
        }

        valid = false;

        
        System.out.println("Enter the password");
        password = scanner.next();

        //Exit out of registry
        if(password.equals("-1")){
            return false;
        }

        System.out.println("Enter Your first name");
        String fName = scanner.next();

        //Exit out of registry
        if(fName.equals("-1")){
            return false;
        }

        System.out.println("Enter your last name");
        String lName = scanner.next();

        //Exit out of registry
        if(lName.equals("-1")){
            return false;
        }


        while(valid == false){
            System.out.println("Enter your email");
            email = scanner.next();

            if(email.contains("@") == false){
                System.out.println("Invalid email, Please re-enter");
            }

            //Exit out of registry
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

                //Exit out of registry
                if (phoneNumber.equals("-1")){
                    return false;
                }
                //Validate that the number contians no letters or special characters
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

            //Exit out of registry
            else if (type.equals("-1")){
                return false;
            }

            else{
                valid = true;
            }
        }
        
        //Enter mothod to register a buyer
        if(type.equals("B"))
        {
            Boolean back = regBuyer(username, password, fName, lName, email, phoneNumber, type);
            //Exit registry
            if (back == true){
                return false;
            }
        }

        //Enter mothod to register a seller
        else if(type.equals("S"))
        {
            Boolean back = regSeller(username, password, fName, lName, email, phoneNumber, type);
            //Exit registry
            if (back == true){
                return false;
            }
        }

        //Enter mothod to register an admin
        else if(type.equals("A"))
        {
            Boolean back = regAdmin(username, password, fName, lName, email, phoneNumber, type);
            //Exit registry
            if (back == true){
                return false;
            }
        }
        return true;
        
    }
    //Method to register a buyer
    public static boolean regBuyer(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type){
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        String prov = "";
        String postalCode = "";

        //Enter the necessary information
        scanner.nextLine();
        System.out.println("Enter the street address");
        String stAdd = scanner.nextLine();

        //Exist registry
        if(stAdd.equals("-1")){
            return true;
        }

        System.out.println("Enter the city");
        String city = scanner.next();

        //Exist registry
        if(city.equals("-1")){
            return true;
        }

        while(valid == false){
        System.out.println("Enter the provice");
        prov = scanner.next();

        
        //Exist registry
        if (prov.equals("-1")){
            return true;
        }

        else if(prov.length() !=2){
            System.out.println("Provice must be 2 charcters long- Please re-enter");
        }
        else{
            valid = true;
        }
        }

        valid = false;

        while (valid == false){
            System.out.println("Please enter the postal code");
            postalCode = scanner.next();

            //Exist registry
             if(postalCode.equals("-1")){
                return true;
            }

            else if(postalCode.length() != 6){
                System.out.println("Postal code must be 6 characters long-Please re-enter");
            }
            
            else{
                valid = true;
            }
        }

        //Create the buyer and the information to the data base
        Buyer user = new Buyer(username, password, firstName, lastName, email, phoneNumber, type, 1, stAdd, city, prov, postalCode);
        try{
        userService.registerUser(user);
        buyerService.registerBuyer(user);
        user.setBuyerID(buyerService.getbuyerID(username));

        //go to the buyer menu
        buyerMenu(user);
        }
        catch(SQLException e){
            System.out.println(e);
            return true;
        }

        
        return false;
    }

    //Method to register a seller
    public static boolean regSeller(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type){
        boolean valid = false;
        Scanner scanner = new Scanner(System.in);
        String prov = "";
        String postalCode = "";

        //Enter the necessary information

        System.out.println("Enter the company name");
        String companyName = scanner.nextLine();

        //Exit to registry
        if(companyName.equals("-1")){
            return true;
        }

        System.out.println("Enter the street address");
        String stAdd = scanner.nextLine();

        //Exit to registry
        if(stAdd.equals("-1")){
            return true;
        }

        System.out.println("Enter the city");
        String city = scanner.next();

        //Exit to registry
        if(city.equals("-1")){
            return true;
        }

        while(valid == false){
        System.out.println("Enter the provice");
        prov = scanner.next();

        //Exit to registry

        if (prov.equals("-1")){
            return true;
        }
        else if(prov.length() !=2){
            System.out.println("Provice must be 2 charcters long- Please re-enter");
        }
        
        else{
            valid = true;
        }
        }

        valid = false;

        while (valid == false){
            System.out.println("Please enter the postal code");
            postalCode = scanner.next();

            //Exit to registry

             if(postalCode.equals("-1")){
                return true;
            }
            else if(postalCode.length() != 6){
                System.out.println("Postal code must be 6 characters long-Please re-enter");
            }
            else{
                valid = true;
            }
        }

        //Create the seller and add the information to the database
        Seller user = new Seller(username, password, firstName, lastName, email, phoneNumber, type, 1, companyName, stAdd, city, prov, postalCode);
        try{
            userService.registerUser(user);
            sellerService.registerSeller(user);
        user.setSellerID(sellerService.getSellerrID(username));
        //Go to Seller meniu
        sellerMenu(user);
        }
        catch(SQLException e){
            System.out.println(e);
            return true;
        }

        
        return false;
    }

    //Method to login
public static boolean login(){
    String username;
    String password;
    Scanner scanner = new Scanner(System.in);
    
    //Have the user enter their username and password
    System.out.println("Enter your username");
    username = scanner.next();

    //exist login
    if(username.equals("-1")){
        return true;
    }

    System.out.println("Enter your password");
    password = scanner.next();

    //Exit login
    if(password.equals("-1")){
        return true;
    }

    //Authenticate the user
    try{
        User user = userService.authUser(username, password);

        if(user != null){
        

            //Enter if the user is a buyer
        if(user.getType().equals("B")){
            
            //get the data from the database
            Buyer buyer = buyerService.getBuyer(user);
            
            //Go to the buyer menu
            buyerMenu(buyer);
        }

        //Enter if the user is a seller
        else if(user.getType().equals("S")){

            //Get the data from the database
            Seller seller = sellerService.getSeller(user);
            //Go to the seller menu
            sellerMenu(seller);
        }

        //Enter if the user is an admin
        else{
            //get the data from the database
            Admin admin = adminService.getAdmin(user);

            adminMenu(admin);
            
        }
        }
        //Return to the main menu
        else{
            return false;
        }
    }
    catch(SQLException e){
        return false;
    }

    return true;

}

    //Method to register an admin
    public static boolean regAdmin(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type){

        Scanner scanner = new Scanner(System.in);

        //Enter the necessary information
        System.out.println("Enter the Admin postion");
        String postion = scanner.next();

        //Exit registry
        if(postion.equals("-1")){
            return false;
        }

        //Create the admin
        Admin user = new Admin(username, password, firstName, lastName, email, phoneNumber, type, 0, postion);

        //Add the admin to the data base
        try{
            userService.registerUser(user);
            adminService.registerAdmin(user);
        user.setAdminID(adminService.getAdminID(username));

        adminMenu(user);
        
        }
        catch(SQLException e){
            System.out.println(e);
            return true;
        }

        return false;
    }

//MEthod to display the buyer menu
public static void buyerMenu(Buyer buyer){
    Scanner scanner = new Scanner(System.in);
    boolean out = false;
    int choice = 0;

    System.out.println("Welcome " + buyer.getUsername());

    while(out == false){
        //Have the user enter their choice
    System.out.println("1: Veiw All Products\n2: Product Search\n3.Exit");
    try{
    choice = scanner.nextInt();
    }
    catch(NumberFormatException e){
        System.out.println("Input must be a number-Please renter");
    }

    switch(choice){
        case 1:
        //Veiw products
        veiwAllProducts();
        break;
        

        case 2:
        //Seach product
        searchProduct();
        break;

        case 3:
        //Log out
        out = true;
        break;

        default:
        System.out.println("Invalid input");
        break;
    }
}
    


   


}

//Method to veiw Products
public static void veiwAllProducts(){
        ArrayList<Product>products = new ArrayList<Product>();

        //Obtain all the products from the data base
    try{
        products = productService.getAllProduct();

        //Display all the products
        for(Product product: products){
            System.out.println(product.getProductName());
            System.out.println("Description: " + product.getDescription());

            System.out.println("Price: " + product.getPrice() + " QTY: " + product.getQty());
            
        }
    }
    catch(SQLException e){
        System.out.println("Cannot access database");
        
    }


}

//Method to search for a specfic product
public static void searchProduct(){
    String productName;
    Scanner scanner = new Scanner(System.in);

    //Have the user enter the product name
    System.out.println("Enter the product Name");
    productName = scanner.next();

try{
    Product product = productService.getProduct(productName);

    //Enter if the product is not in the data base
    if(product == null){
        System.out.println("Could not find product");

    
    }

    //Display the product
    else{
        System.out.println(product.getProductName());
        System.out.println("Description: " + product.getDescription());

        System.out.println("Price: " + product.getPrice() + " QTY: " + product.getQty());
    }

    
}
catch(SQLException e){
    System.out.println(e);
}



}

//Method to display the seller menu
public static void sellerMenu(Seller seller){
    
        System.out.println("Welcome to the Seller Menu");


        Scanner scanner = new Scanner(System.in);
        String menuCheck;
        int choice = 0;
        boolean validInput = false;

        while(validInput == false){
            
        
        System.out.println("1. View Seller Products");
        System.out.println("2. Add Product");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("Please select option 1-4");
        menuCheck = scanner.next();
        try{
            choice = Integer.valueOf(menuCheck);
        }
        catch(NumberFormatException e){

        }
    
            
                

                switch (choice) {

                    //Enter to veiw products
                    case 1:
                    try{
                        //Obtain the products from the database
                    ArrayList<Product>products = productService.getSellerProduct(seller.getSellerID());

                    //Enter if the seller has no products
                    if(products == null){
                        System.out.println("You have no products to sell");
                    }

                    else{
                        //Display all of the seller's products
                        for(Product product: products){
                            System.out.println(product.getProductName());
                            System.out.println("Description: " + product.getDescription());

                            System.out.println("Price: " + product.getPrice() + " QTY: " + product.getQty());
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
                    double price = 0;
                    int qty = 0;
                    String description;
                    int sellerID;
                    boolean valid = false;

                    scanner.nextLine();
                    //Enter the necessary information
                    System.out.println("Enter the product name");
                    productName = scanner.nextLine();
                    

                    System.out.println("Enter the product description");
                    
                    description = scanner.nextLine();


                    while(valid == false)
                    {
                        System.out.println("Enter the product price");
                       String check = scanner.next();
                        
                        try{
                            price = Double.parseDouble(check);
                        
                        valid = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Price must be a number - Please re-enter");
                        }

                    }

                    valid = false;

                    while (valid == false){

                    System.out.println("Enter the product quantity");
                        String check = scanner.next();
                        try{
                        qty = Integer.parseInt(check);
                    valid = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Quantity must be a number - Please re-enter");
                        }
                    }

                    
                    sellerID = seller.getSellerID();


                    //Create the product
                     Product p = new Product(0, productName, price, qty, description, sellerID);
                     try{
                        //add the product to the database
                     productService.registerProduct(p);
                     }
                     catch(SQLException e){
                        System.out.println("Problem with the database");
                        System.out.println(e);
                     }
                     break;

                     //Update product
                    case 3:
                    scanner.nextLine();
                    Product product = null;
                    Boolean noError = true;
                    valid = false; 

                    //Have the user enter the name of the product they wish to update
                    System.out.println("Enter the name of the product you wish to update");
                     productName = scanner.nextLine();

                     //Search the database for the product
                     try{
                      product = productService.getProduct(productName);

                     }
                     catch(SQLException e){
                        System.out.println(e);
                        noError = false;
                     }

                     if(noError){
                        //Enter if the product does no exist
                        if(product == null){
                            System.out.println(productName + " does not exisit");
                        }
                        else{
                            scanner.nextLine();

                    //Enter the necessary information
                    System.out.println("Enter the product name");
                    productName = scanner.nextLine();
                    

                    System.out.println("Enter the product description");
                    
                    description = scanner.nextLine();


                    while(valid == false)
                    {
                        try{
                        System.out.println("Enter the product price");
                        price = scanner.nextDouble();
                        valid = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Price must be a number - Please re-enter");
                        }

                    }

                    valid = false;

                    while (valid == false){
                        try{
                    System.out.println("Enter the product quantity");
                    qty = scanner.nextInt();
                    valid = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("Quantity must be a number - Please re-enter");
                        }
                    }
                            try{
                                //Update the product
                            productService.updateProduct(product, productName);
                            }
                            catch(SQLException e){
                                System.out.println(e);
                            }
                        }
                     }
                     break;

                     //Deleate product
                     case 4:
                     product = null;
                     noError = true;
                     scanner.nextLine();

                     //Have the user enter the name of the product they wish to delete
                    System.out.println("Enter the name of the product you wish to update");
                     productName = scanner.nextLine();

                     try{
                        //Search the database for the product
                      product = productService.getProduct(productName);

                     }
                     catch(SQLException e){
                        System.out.println(e);
                        noError = false;
                     }

                     if(noError){
                        //Enter if the product does not exist
                        if(product == null){
                            System.out.println(productName + " does not exisit");
                        }

                        //Delete the product
                        else{
                            try{
                                productService.deleteProduct(productName);
                            }
                            catch(SQLException e){
                                System.out.println(e);
                            }
                        }
                    }
                    break; 

                    //Enter to log out
                    case 5:
                    validInput = true;
                    break;

                    default:
                    System.out.println("Invalid input-Please re-enter");
                    break;
                
            }
        }

        
}
public static void adminMenu(Admin admin) {

    System.out.println("Welcome to the Admin Menu");

    Scanner scanner = new Scanner(System.in);
    String menuCheck;
    int choice = 0;
    boolean validInput = false;

    while(validInput == false){
        System.out.println("1. View Users");
        System.out.println("2. Delete Users");
        System.out.println("3. List Products");
        System.out.println("4. Search Products");
        System.out.println("5. exit");
        System.out.println("Please select option 1-5");
        menuCheck = scanner.next();
        try{
            choice = Integer.valueOf(menuCheck);
        }
        catch(NumberFormatException e){

        }
        switch (choice) {
            case 1:
            try {
                ArrayList<User>users = adminService.getAllUser();
                if(users == null){
                    System.out.println("There are currently no users");
                }
            else {
                for (User user: users) {
                    System.out.println("Name:"  + user.getFirstName() + " " + user.getLastName());
                    System.out.println("Username:"  + user.getUsername() + ", Email " + user.getEmail() + ", Phone  number" + user.getPhoneNumber()) ;
                    System.out.println("Type: " + user.getType()) ;
                }
            }}
            catch (SQLException e) {
                System.out.println(e);
            }
            break;

            case 2:
            User user = null;
            boolean noError = true;
            scanner.nextLine();

            System.out.println("Enter the username of the user you wish to delete");
            String username = scanner.nextLine();
            
            try {
                user = userService.getUser(username);
            }
            catch (SQLException e) {
                System.out.println(e);
                noError = false;
            }
            if(noError){
                if(user == null){
                    System.out.println("There is no user under this name");
                }

                else {
                    try {
                        String confirmation = "";
                        //Loop until a valid response is given
                        while (true) {
                            System.out.println("Are you sure you wish to delete this user? This will also delete their product listings. Y/N");
                            confirmation = scanner.nextLine().trim().toUpperCase();
                    
                            //Check for valid input
                            if (confirmation.equals("Y")) {
                                //Admin chose to delete, proceed to delete user and their products
                                if (user.getType().equals("S")){
                                    Seller seller = sellerService.getSeller(user);
                                    productService.deleteProductBySellerID(seller.getSellerID());
                                    sellerService.deleteSellerByUsername(username);
                                    userService.deleteUser(username);
                                    System.out.println("User and their product listings have been deleted.");

                                }
                                else if(user.getType().equals("B")) {
                                    buyerService.deleteBuyerByID(username);
                                    userService.deleteUser(username);
                                }
                                else{
                                    adminService.deleteAdminByID(username);
                                    userService.deleteUser(username);
                                }
                                
                                break;
                            } else if (confirmation.equals("N")) {
                                //Admin chose to not delete, exit operation
                                System.out.println("Deletion canceled.");
                                return;
                            } else {
                                //Handle invalid input
                                System.out.println("Invalid input. Please enter 'Y' to confirm or 'N' to cancel.");
                            }
                        }}
                    catch (SQLException e) {
                        System.out.println(e);
                        noError = false;
                    }
                }
            }
            break;

            case 3:
            try {
                ArrayList<Product>products = productService.getAllProduct();
                if(products == null) {
                    System.out.println("There are currently no products");
                }
                else {
                    for (Product product: products) {
                        User tempSeller = sellerService.getSeller(userService.getUserByUsername(productService.getSellerUsername(product.getSellerID())));
                
                        Seller seller = sellerService.getSeller(tempSeller);

                        System.out.println(product.getProductName());
                        System.out.println("Description: " + product.getDescription());

                        System.out.println("Price: " + product.getPrice() + " QTY: " + product.getQty());
                        System.out.println("Name:"  + seller.getFirstName() + " " + seller.getLastName());
                        System.out.println("Username:"  + seller.getUsername() + ", Email " + seller.getEmail() + ", Phone  number" + seller.getPhoneNumber()) ;
                        System.out.println("Address:" + seller.getStAdd() + ", " + seller.getCity() + ", " + seller.getProv() + ", " + seller.getPostalCode());
                        System.out.println();
                    }}
                }
                catch (SQLException e) {
                    System.out.println(e);
                } 
            break;

            case 4:
            String productName = "";
            System.out.println("Enter the product Name");
            scanner.nextLine();
            productName = scanner.nextLine();
        
        try{
            Product product = productService.getProduct(productName);
        
            //Enter if the product is not in the data base
            if(product == null){
                System.out.println("Could not find product");
        
            
            }
        
            //Display the product
            else{
                
                User tempSeller = sellerService.getSeller(userService.getUserByUsername(productService.getSellerUsername(product.getSellerID())));
                
                Seller seller = sellerService.getSeller(tempSeller);
                System.out.println(product.getProductName());
                System.out.println("Description: " + product.getDescription());
        
                System.out.println("Price: " + product.getPrice() + " QTY: " + product.getQty());
                System.out.println("Price: " + product.getPrice() + " QTY: " + product.getQty());
                System.out.println("Name:"  + seller.getFirstName() + " " + seller.getLastName());
                System.out.println("Username:"  + seller.getUsername() + ", Email " + seller.getEmail() + ", Phone  number" + seller.getPhoneNumber()) ;
                System.out.println("Address:" + seller.getStAdd() + ", " + seller.getCity() + ", " + seller.getProv() + ", " + seller.getPostalCode());
            }
        
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        break;

        case 5:
        validInput = true;
        break;

        default:
        System.out.println("Invalid input - Please re-enter");
    }
}
}


    public static void main(String[] args) {
    boolean valid = false;
    Scanner scanner = new Scanner(System.in);

    //Have the user input if they want to register or login
    while (valid == false){
   System.out.println("Do you want to register or login");
   String option = scanner.next();
   
    
   //Enter if the user wishes to register
   if(option.equals("R")){
    register();
   }

   //Enter if the user wishes to login
   else if(option.equals("L")){
    
        login();
    
   }

   //Enter to shut down program
   else if(option.equals("-1")){
    valid = false;
   }

   else{
    System.out.println("Invalid input, Please re-enter");
   }
}

}    
}
