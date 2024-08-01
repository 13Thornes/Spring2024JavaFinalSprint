public class demo {
public static void main(String[] args) {
    Product p1 = new Product(1, "Ball", 4.99, 10, "A red bouncy ball", 4);
    Product p2 = new Product(2, "Frisbee", 5.99, 15, "A yellow flying disk", 5);
    Buyer b1 = new Buyer("Johnny123", "Play456", "John", "Doe", "jdoe@mail.com", "1234567890", 1, "123 Main st", "Corner Brook", "NL", "A2H 5L1");

    b1.addProduct(p1);
    b1.addProduct(p2);
    // b1.viewProducts();
    b1.viewProduct("Ball");

}    
}
