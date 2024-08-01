public class Product {
    
    int productID;
    String productName;
    double price;
    int qty;
    String description;
    int sellerID;
    

    public Product(int productID, String productName, double price, int qty, String description, int sellerID) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.sellerID = sellerID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String toString() {
        return "Product [productID=" + productID + ", productName=" + productName + ", price=" + price + ", qty=" + qty
                + ", description=" + description + ", sellerID=" + sellerID + "]";
    }

    public void updateProduct(int productID, String productName, double price, int qty, String description, int sellerID) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.qty = qty;
        this.description = description;
        this.sellerID = sellerID;
    }

    


    

    
}
