package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entity.Order;

public class OrderDB {
    private static final OrderDB orderDB = new OrderDB();

    public static OrderDB getInstance() {
        return orderDB;
    }

    private final ArrayList<Order> orderList = new ArrayList<>();

    public void insertOrder(Order order) {
        orderList.add(order);
    }
    public void deleteOrder(Order order){
        orderList.remove(order);
    }

    public Optional<Order> getOrderByOrderId(String orderId) {
        Order findOrder = null;
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                findOrder = order;
                break;
            }
        }
        return Optional.ofNullable(findOrder);
    }
    
    public List<Order> getAllOrderByUserID(String userID) {
        return orderList.stream().filter(x -> x.getUser().getUserID().equals(userID)).collect(Collectors.toList());
    }

    public List<Order> getAllOrders() {
        return orderList.stream().collect(Collectors.toList());
    }
}
