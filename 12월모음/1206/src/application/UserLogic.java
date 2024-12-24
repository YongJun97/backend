package application;

import static printer.Printer.EXCEPTION_DOUBLE_ID;
import static printer.Printer.EXCEPTION_NO_ID;
import static printer.Printer.EXCEPTION_WRONG_PW;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import data.OrderDB;
import data.ProductDB;
import data.UserDB;
import entity.Order;
import entity.Product;
import entity.User;


public class UserLogic {

    UserDB userDB = UserDB.getInstance();
    OrderDB orderDB = OrderDB.getInstance();

    private static UserLogic userLogic = new UserLogic();

    public static UserLogic getInstance() {
        return userLogic;
    }

    public User signUp(String name, String id, String pw) {
        Optional<User> opUser = userDB.getUserByUserId(id);
        if (opUser.isPresent()) {
            throw new IllegalArgumentException(EXCEPTION_DOUBLE_ID);
        }
        User user = new User(id, pw, name, false);
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
    
    public Order makeOrder(User loginUser){
        // generate fresh id
        int i = 0;
        String newOrderId = "";
        while (true) {
            newOrderId = loginUser.getUserID() + Integer.toString(i);
            if(OrderDB.getInstance().getOrderByOrderId(newOrderId).isEmpty()){
                break;
            }
            i++;
        }

        // make order
        Order order = new Order(newOrderId, loginUser);
        orderDB.insertOrder(order);
        return order;
    }

    public Order addToOrder(User loginUser, Order order, Product product, int quantity){
        if (order.getUser().equals(loginUser)) {
            order.addList(product, quantity);
        } else{
            throw new IllegalArgumentException("주문자가 아닙니다.");
        }
        return order;
    }
    
    public Order removeFromOrder(User loginUser, Order order, Product product, int quantity){
        if (order.getUser().equals(loginUser)) {
            order.removeList(product, quantity);
        } else{
            throw new IllegalArgumentException("주문자가 아닙니다.");
        }
        return order;
    }

    public List<Order> getAllOrdersOfUser(User loginUser){
        List<Order> orders = OrderDB.getInstance().getAllOrders();
        return 
        orders.stream()
        .filter(o -> o.getUser().equals(loginUser))
        .collect(Collectors.toList());
    }

    public Order getOrderById(User loginUser, String orderId){
        Optional<Order> opOrder = OrderDB.getInstance().getOrderByOrderId(orderId);
        Order order = opOrder.orElseThrow(() -> new IllegalArgumentException("주문 번호가 존재하지 않습니다."));
        if (order.getUser().equals(loginUser)) {
            return order;
        } else{
            throw new IllegalArgumentException("주문자가 아닙니다.");
        }
    }

    public Product getProductByProductId(String productId) {
        Optional<Product> opProduct = ProductDB.getInstance().getProductByProductId(productId);
         Product product = opProduct.orElseThrow(() -> new IllegalArgumentException("상품 번호가 존재하지 않습니다."));
         return product;
    }

    public List<Product> getAllProducts() {
        return ProductDB.getInstance().getAllProducts();
    }
}