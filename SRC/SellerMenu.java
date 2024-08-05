import java.util.Scanner;

public class SellerMenu {
    public static void main(String[] args) {

        Seller s1 = new Seller("lumpy", "sofa21", "John", "Doe", "lsofa@mail.com", "1234567890", 1, "123 Main St", "Corner Brook", "NL", "A2H 7H2");

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
    
            if(choice > 1 && choice < 4 ){
                validInput = true;

                switch (choice) {
                    case 1:
                    // view products
                        
                        break;

                    case 2:
                    addProduct();
                    // add product
                    // int productID;
                    // String productName;
                    // double price;
                    // int qty;
                    // String description;
                    // int sellerID;

                    // System.out.println("Please enter the product ID");
                    // productID = scanner.nextInt();
                    

                    // System.out.println("Enter the product name");
                    // productName = scanner.nextLine();
                    // scanner.nextLine();
        

                    // System.out.println("Enter the product price");
                    // price = scanner.nextDouble();

                    
                    // System.out.println("Enter the product quantity");
                    // qty = scanner.nextInt();

                    // System.out.println("Enter the product description");
                    // description = scanner.nextLine();
                    // scanner.nextLine();

                    // System.out.println("Enter the seller's ID");
                    // sellerID = scanner.nextInt();


                    // Product p = new Product(productID, productName, price, qty, description, sellerID);

                    

                    

                    


                        break;
                    
                    case 3:
                    // update product
                    

                        break;

                    case 4: 
                    // delete product

                        break;

                
                    default:
                    System.out.println("Invalid input");
                        break;
                }
                
            }
    
            else{
                System.out.println("Invalid Input");
            }
        }
    
        validInput = false;

    }
}
