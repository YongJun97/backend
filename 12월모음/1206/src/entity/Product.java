package entity;

public class Product {
    private String ProductId;
    private String ProductName;
    private int price;
    public Product(String productId, String productName, int price) {
        ProductId = productId;
        ProductName = productName;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", price=" + price + "]";
    }
    public String getProductId() {
        return ProductId;
    }
    public void setProductId(String productId) {
        ProductId = productId;
    }
    public String getProductName() {
        return ProductName;
    }
    public void setProductName(String productName) {
        ProductName = productName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

}
