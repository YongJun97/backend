package presentation;

import application.AdminLogic;
import application.UserLogic;
import entity.Order;
import entity.Product;
import entity.User;

import java.util.List;
import java.util.Scanner;

import static printer.Printer.*;

public class AdminUI {
    Scanner scanner = new Scanner(System.in);
    AdminLogic adminLogic = AdminLogic.getInstance();
    UserLogic userLogic = UserLogic.getInstance();
    User loginUser;
    String message = "";

    public void adminApp(User user) {
        loginUser = user;
        while (true) {
            try{
                clearCmd();
                println(BLANK + message);
                println(BLANK + BLANK_HALF + loginUser.getUserName() + ADMIN_WELCOME_SUFFIX);
                println(BLANK + HEADER_ADMIN);
                println(BLANK + ADMIN_LIST1);
                println(BLANK + ADMIN_LIST2);
                println(BLANK + ADMIN_LIST3);
                println(BLANK + ADMIN_LIST4);
                println(BLANK + ADMIN_LIST5);
                println(BLANK + ADMIN_LIST6);
                println(BLANK + ADMIN_LIST7);
                println(BLANK + ADMIN_LIST8);
                println(BLANK + ADMIN_LIST9);
                println(BLANK + ADMIN_LIST0);
                println(BLANK + FOOTER);
                print(BLANK + ENTER_TASK_NUM);
                switch (scanner.nextLine()) {
                    case "1" -> changeUserPassword();
                    case "2" -> showOrderList();
                    case "3" -> listOrdersByUserId();
                    case "4" -> searchOrder();
                    case "5" -> deleteOrder();
                    case "6" -> showProductList();
                    case "7" -> searchProduct();
                    case "8" -> AddProduct();
                    case "9" -> DeleteProduct();
                    case "0" -> {
                        return;
                    }
                    default -> message = MESSAGE_WRONG_INPUT;
                }
                
            } catch (Exception e) {
                setMessage(e.getMessage());
            }
        }
    }

    private void showOrderList() {
        StringBuilder sb = new StringBuilder();
        adminLogic.getAllOrders().forEach(o->{
            sb.append(o.toString()).append("\n");
            setMessage(sb.toString());
        });
    }

    private void listOrdersByUserId() {
        StringBuilder sb = new StringBuilder();

        println("유저 ID를 입력해 주세요");
        String userId = scanAndGetString();
        List<Order> orderList = adminLogic.getOrdersByUserId(userId);
        if (orderList.isEmpty()) {
            println(BLANK + MESSAGE_NO_ORDER);
        } else {
            orderList.forEach(p -> {
                sb.append(p.toString()).append("\n");
                setMessage(sb.toString());
            });
        }
    }

    private void searchOrder() {
        println("주문번호를 입력해 주세요");
        String orderId = scanAndGetString();
        Order order = adminLogic.getOrderByID(orderId);
        if (order == null) {
            setMessage(BLANK + MESSAGE_NO_ORDER);
        } else {
            setMessage(order.toString());
        }
    }

    private void deleteOrder() {
        println("주문번호를 입력해 주세요");
        String orderId = scanAndGetString();
        adminLogic.removeOrder(orderId);
        setMessage("삭제 완료되었습니다.");
    }

    private void showProductList() {
        StringBuilder sb = new StringBuilder();
        adminLogic.getAllProducts().forEach(p->
        sb.append(p.toString()).append("\n"));
        setMessage(sb.toString());
    }

    private void searchProduct() {
        println("상품 번호를 입력해주세요");
        String productId = scanAndGetString();
        Product p = adminLogic.getPruductById(productId);
            setMessage(p.toString());
    }

    // addProduct
    private void AddProduct() {
        println("상품 번호를 입력해 주세요");
        String productId = scanAndGetString();
        println("상품 이름을 입력해 주세요");
        String productName = scanAndGetString();
        println("상품 가격을 입력해 주세요");
        int price = scanAndGetParsedInt();
        adminLogic.addProduct(productId, productName, price);
        setMessage("상품이 추가 되었습니다.");

    }

    private void DeleteProduct() {
        println("상품 번호를 입력해 주세요");
        String productId = scanAndGetString();
        adminLogic.removeProduct(productId);
        setMessage("삭제 완료되었습니다.");
    }

    private void changeUserPassword() {
        clearCmd();
        println(BLANK + HEADER_CHANGE_PASSWORD);
        findAllUserID();
        print(BLANK + ENTER_USER_ID);
        String userId = scanAndGetString();
        try {
            adminLogic.confirmId(userId);
        } catch (Exception e) {
            setMessage(MESSAGE_WRONG_INPUT);
            return;
        }
        print(BLANK + ENTER_NEW_PW);
        String newPassword = scanAndGetString();
        adminLogic.changeUserPw(userId, newPassword);
        setMessage(MESSAGE_SUCCESS_LOGIC);
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

    private void findAllUserID() {
        println(BLANK + ALL_USER_ID);
        List<User> accounts = adminLogic.getAllUsers();
        for (User account : accounts) {
            println(BLANK + USER_ID + account.getUserID() +USER_NAME+account.getUserName());
        }
    }

    private void setMessage(String s) {
        message = s;
    }

    private String scanAndGetString() {
        return scanner.nextLine();
    }
}