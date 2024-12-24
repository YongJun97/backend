package entity;

import java.util.HashMap;

public class Order {
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", user=" + user + ", shoppingList=" + shoppingList + ", totalPrice="
                + totalPrice + "]";
    }
    private String orderId;
    private User user;
    private HashMap<Product,Integer> shoppingList;
    private int totalPrice;
    public Order(String orderId, User user) {
        this.orderId = orderId;
        this.user = user;
        shoppingList = new HashMap<>();
        totalPrice = 0;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public HashMap<Product, Integer> getShoppingList() {
        return shoppingList;
    }
    public void setShoppingList(HashMap<Product, Integer> shoppingList) {
        this.shoppingList = shoppingList;
        this.totalPrice = 0;
        this.shoppingList.forEach((product, quantity)->
        this.totalPrice += product.getPrice() * quantity
        );
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void addList(Product product, int quantity){
        if(this.shoppingList.containsKey(product)){
            this.shoppingList.put(product, this.shoppingList.get(product) + quantity);
        }else{
            this.shoppingList.put(product, quantity);
        }
        this.totalPrice += product.getPrice() * quantity;
    }
    public void removeList(Product product, int quantity){
        if(this.shoppingList.containsKey(product)){
            this.shoppingList.put(product, this.shoppingList.get(product) - quantity);
            if(this.shoppingList.get(product) <= 0){
                this.totalPrice -= product.getPrice() * this.shoppingList.get(product);
                this.shoppingList.remove(product);
                return;
            }
        }
        this.totalPrice -= product.getPrice() * quantity;
    }
}
