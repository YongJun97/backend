package application;

import static printer.Printer.EXCEPTION_DOUBLE_ID;
import static printer.Printer.EXCEPTION_NO_ID;
import static printer.Printer.EXCEPTION_WRONG_PW;
import static printer.Printer.MESSAGE_NO_PRODUCT;

import java.util.List;
import java.util.Optional;

import data.OrderDB;
import data.ProductDB;
import data.UserDB;
import entity.Order;
import entity.Product;
import entity.User;


public class AdminLogic {
    UserDB userDB = UserDB.getInstance();
    ProductDB productDB = ProductDB.getInstance();
    OrderDB orderDB = OrderDB.getInstance();

    private static final AdminLogic adminLogic = new AdminLogic();

    public static AdminLogic getInstance() {
        return adminLogic;
    }

    public User signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isPresent()) {
            throw new IllegalArgumentException(EXCEPTION_DOUBLE_ID);
        }
        User user = new User(id, pw, name, true);
        userDB.insertUser(user);
        return user;
    }

    public User login(String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        User user = opUser.orElseThrow(() -> new IllegalArgumentException(EXCEPTION_NO_ID));
        if (!user.getPassWord().equals(pw)) {
            throw new IllegalArgumentException(EXCEPTION_WRONG_PW);
        }
        return user;
    }

    public Optional<User> confirmId(String id) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_NO_ID);
        }
        return opUser;
    }

    public void changeUserPw(String id, String pw) {
        Optional<User> user = confirmId(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_NO_ID);
        }
        User foundUser = user.get();
        foundUser.changeUserPassword(pw);
    }

    // addProduct
    public void addProduct(String productId, String productName, int price) {
        if(productDB.getAllProducts().stream().anyMatch(p -> p.getProductId().equals(productId))){
            throw new IllegalArgumentException("이미 존재하는 상품입니다.");
        }
        Product product = new Product(productId, productName, price);
        productDB.insertProduct(product);
    }
    // removeProduct
    public void removeProduct(String productId) {
        Optional<Product> product = productDB.getProductByProductId(productId);
         if(product.isEmpty()){
             throw new IllegalArgumentException("존재하지 않는 상품입니다.");
         }
         productDB.deleteProduct(product.get());
    }

    public List<Product> getAllProducts(){
        return productDB.getAllProducts();
    }


    // remove order
    public void removeOrder(String orderId) {
        Optional<Order> order = orderDB.getOrderByOrderId(orderId);
        if(order.isEmpty()){
            throw new IllegalArgumentException("존재하지 않는 주문입니다.");
        }
        orderDB.deleteOrder(order.get());
    }
    
    public List<Order> getAllOrders(){
        return orderDB.getAllOrders();
    }

    public List<User> getAllUsers() {
        return userDB.getAllUsers();
    }

    public User findUserById(String id) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_NO_ID);
        }
        return opUser.get();
    }

    public Order getOrderByID(String id) {
        Optional<Order> opOrder = orderDB.getOrderByOrderId(id);
        if (opOrder.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_NO_ID);
        }
        return opOrder.get();
    }
    public List<Order> getOrdersByUserId(String id) {
        return orderDB.getAllOrderByUserID(id);
    }

    public Product getPruductById(String productId) {
        Optional<Product> opProduct = productDB.getProductByProductId(productId);
        if (opProduct.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_NO_PRODUCT);
        }
        return opProduct.get();
    }
}