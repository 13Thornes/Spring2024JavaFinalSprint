import java.util.ArrayList;

public class Buyer extends User {

    int buyerID;
    String stAdd;
    String city;
    String prov;
    String postalCode;
    ArrayList<Product> productList = new ArrayList<Product>();

    public Buyer(String username, String password, String firstName, String lastName, String email, String phoneNumber, int buyerID, String stAdd, String city, String prov, String postalcode) {
        super(username, password, firstName, lastName, email, phoneNumber);
        this.buyerID = buyerID;
        this.stAdd = stAdd;
        this.city = city;
        this.prov = prov;
        this.postalCode = postalcode;
    }

    public int getBuyerID() {
        return buyerID;
    }
    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
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

   
    @Override
    public String toString() {
        return (super.toString() + "Buyer [buyer_ID=" + buyerID + ", stAdd=" + stAdd + ", city=" + city + ", prov=" + prov
                + ", postalCode=" + postalCode + "]");
    }
    
    public void addProduct(Product product) {
        if(productList.contains(product)) {
            System.out.println("Product already exists");
        } else {
            productList.add(product);
            System.out.println(product.productName + " added");
        }  
    }

    public void removeProduct(Product product) {
        if(productList.contains(product)) {
            productList.remove(product);
            System.out.println(product.productName + " removed");
        } else {
            System.out.println("Product not found");
        }
    }

    public void viewProducts() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    public void viewProduct(String productName) {
        for (Product product : productList) {
            if(product.productName.equals(productName)) {
            System.out.println(product.toString());
            }
        }
    }
    
}