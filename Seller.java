import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Seller extends User {

    private int sellerID;
    private String stAdd;
    private String city;
    private String prov;
    private String postalCode;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private List<Product> products;

    // Constructor
    public Seller(String username, String password, String firstName, String lastName, String email, String phoneNumber,
                  int sellerID, String stAdd, String city, String prov, String postalCode) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sellerID = sellerID;
        this.stAdd = stAdd;
        this.city = city;
        this.prov = prov;
        this.postalCode = postalCode;
        this.products = new ArrayList<>();
    }

    // Getters and Setters
    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getStAdd() {
        return stAdd;
    }

    public void setStAdd(String stAdd) {
        this.stAdd = stAdd;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Product management methods
    public List<Product> viewSellerProducts() {
        return products;
    }

    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        int productID;
        String productName;
        double price;
        int qty;
        String description;
        int sellerID;

        System.out.println("Please enter the product ID");
                    productID = scanner.nextInt();
                    

                    System.out.println("Enter the product name");
                    productName = scanner.nextLine();
                    scanner.nextLine();
        

                    System.out.println("Enter the product price");
                    price = scanner.nextDouble();

                    
                    System.out.println("Enter the product quantity");
                    qty = scanner.nextInt();

                    System.out.println("Enter the product description");
                    description = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Enter the seller's ID");
                    sellerID = scanner.nextInt();


                    Product p = new Product(productID, productName, price, qty, description, sellerID);

                    products.add(p);

                    System.out.println("Product added");


    }

    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        int productID;
        String productName;
        double price;
        int qty;
        String description;
        int sellerID;

        System.out.println("Please enter the product ID");
                    productID = scanner.nextInt();


        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == productID) {
                System.out.println("Enter the new product name");
                    productName = scanner.nextLine();
                    scanner.nextLine();
        

                    System.out.println("Enter the new product price");
                    price = scanner.nextDouble();

                    
                    System.out.println("Enter the new product quantity");
                    qty = scanner.nextInt();

                    System.out.println("Enter the new product description");
                    description = scanner.nextLine();
                    scanner.nextLine();

                    System.out.println("Enter the seller's ID");
                    sellerID = scanner.nextInt();


                    Product p = new Product(productID, productName, price, qty, description, sellerID);


                products.set(i, p);
                System.out.println("Product updated");
                return;
            }
        }
    }

    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        int productID;

        System.out.println("Please enter the product ID");
        productID = scanner.nextInt();

        products.removeIf(p -> p.getProductID() == productID);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerID=" + sellerID +
                ", stAdd='" + stAdd + '\'' +
                ", city='" + city + '\'' +
                ", prov='" + prov + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    
}
