package presentation;

import static printer.Printer.BLANK;
import static printer.Printer.BLANK_HALF;
import static printer.Printer.ENTER_TASK_NUM;
import static printer.Printer.FOOTER;
import static printer.Printer.HEADER_USER;
import static printer.Printer.HEADER_USER_WELCOME;
import static printer.Printer.MESSAGE_WRONG_INPUT;
import static printer.Printer.USER_LIST0;
import static printer.Printer.USER_LIST1;
import static printer.Printer.USER_LIST2;
import static printer.Printer.USER_LIST3;
import static printer.Printer.USER_LIST4;
import static printer.Printer.USER_LIST5;
import static printer.Printer.USER_LIST6;
import static printer.Printer.USER_LIST7;
import static printer.Printer.clearCmd;
import static printer.Printer.print;
import static printer.Printer.println;

import java.util.Scanner;

import application.UserLogic;
import entity.Order;
import entity.Product;
import entity.User;

public class UserUI {
    Scanner scanner = new Scanner(System.in);
    UserLogic userLogic = UserLogic.getInstance();
    User loginUser;
    String message;

    public void userApp(User user) {
        loginUser = user;
        message = "";
        while (true) {
            try {
                
            clearCmd();
            println(BLANK + message);
            println(BLANK + BLANK_HALF + loginUser.getUserName() + HEADER_USER_WELCOME);
            println(BLANK + HEADER_USER);
            println(BLANK + USER_LIST1);
            println(BLANK + USER_LIST2);
            println(BLANK + USER_LIST3);
            println(BLANK + USER_LIST4);
            println(BLANK + USER_LIST5);
            println(BLANK + USER_LIST6);
            println(BLANK + USER_LIST7);
            println(BLANK + USER_LIST0);
            println(BLANK + FOOTER);
            print(BLANK + ENTER_TASK_NUM);
            switch (scanAndGetString()) {
                case "1" -> showOrderList();
                case "2" -> searchOrder();
                case "3" -> makeNewOrder();
                case "4" -> addProduct();
                case "5" -> removeProduct();
                case "6" -> showProductList();
                case "7" -> searchProduct();
                case "0" -> {
                    return;
                }
                default -> setMessage(MESSAGE_WRONG_INPUT);
            }

            } catch (Exception e) {
                setMessage(e.getMessage());
            }
        }
    }

    

    
    private void searchProduct() {
        println("상품 ID를 입력해주세요");
        String productId = scanAndGetString();
        Product product = userLogic.getProductByProductId(productId);
        setMessage(product.toString());
    }



    private void showProductList() {
        StringBuilder msgBuilder = new StringBuilder();
        userLogic.getAllProducts().forEach(p->{
            msgBuilder.append(p.toString()).append("\n");
            setMessage(msgBuilder.toString());
        });;

    }



    private void removeProduct() {
        println("주문ID를 입력하세요");
        String orderId = scanAndGetString();
        Order order = userLogic.getOrderById(loginUser, orderId);
        println("상품ID를 입력하세요");
        String productId = scanAndGetString();
        Product product = userLogic.getProductByProductId(productId);
        println("수량를 입력하세요");
        int quantity = scanAndGetParsedInt();

        
        userLogic.removeFromOrder(loginUser, order, product, quantity);
        // println(order.toString());
        setMessage("상품이 제거되었습니다");
    }



    private void addProduct() {
        println("주문ID를 입력하세요");
        String orderId = scanAndGetString();
        Order order = userLogic.getOrderById(loginUser, orderId);
        println("상품ID를 입력하세요");
        String productId = scanAndGetString();
        Product product = userLogic.getProductByProductId(productId);
        println("수량를 입력하세요");
        int quantity = scanAndGetParsedInt();


        userLogic.addToOrder(loginUser, order, product, quantity);
        // println(order.toString());
        setMessage("상품이 추가되었습니다");
    }



    private void makeNewOrder() {
        Order newOrder= userLogic.makeOrder(loginUser);
        // println(newOrder.toString());
        setMessage("주문이 생성되었습니다");
    }



    private void searchOrder() {
        println("주문ID를 입력하세요");
        String orderId = scanAndGetString();

        Order order= userLogic.getOrderById(loginUser, orderId);
        setMessage(order.toString());
    }



    private void showOrderList() {
        StringBuilder sb = new StringBuilder();
        userLogic.getAllOrdersOfUser(loginUser).stream().forEach((order)->{
            sb.append(order.toString()).append("\n");
        });
        setMessage(sb.toString());
    }

    private void setMessage(String s) {
        message = s;
    }

    private String scanAndGetString() {
        return scanner.nextLine();
    }

    public int scanAndGetParsedInt() {
        String s = scanner.nextLine();
        int idx;
        try {
            idx = Integer.parseInt(s);
            if (idx <= 0) {
                return -1;
            }
        } catch (Exception e) {
            return -1;
        }
        return idx;
    }
}
