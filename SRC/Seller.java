import java.util.ArrayList;
import java.util.List;

public class Seller extends User {

    private int sellerID;
    private String stAdd;
    private String city;
    private String prov;
    private String postalCode;
    
    

    private List<Product> products;

    // Constructor
    public Seller(String username, String password, String firstName, String lastName, String email, String phoneNumber, String type,
                  int sellerID, String stAdd, String city, String prov, String postalCode) {
        super(username, password, firstName, lastName, email, phoneNumber, type);
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

    // Product management methods
    public List<Product> viewSellerProducts() {
        return new ArrayList<>(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID() == product.getProductID()) {
                products.set(i, product);
                return;
            }
        }
    }

    public void deleteProduct(Product product) {
        products.removeIf(p -> p.getProductID() == product.getProductID());
    }

    @Override
    public String toString() {
        return ( super.toString() + "Seller{" +
                "sellerID=" + sellerID +
                ", stAdd='" + stAdd + '\'' +
                ", city='" + city + '\'' +
                ", prov='" + prov + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}');
    }
    
}
