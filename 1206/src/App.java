import static printer.Printer.ADMIN_PREFIX;
import static printer.Printer.BLANK;
import static printer.Printer.ENTER_ID;
import static printer.Printer.ENTER_NAME;
import static printer.Printer.ENTER_PW;
import static printer.Printer.ENTER_TASK_NUM;
import static printer.Printer.EXCEPTION_DOUBLE_ID;
import static printer.Printer.EXCEPTION_NO_ID;
import static printer.Printer.EXCEPTION_WRONG_PW;
import static printer.Printer.FOOTER;
import static printer.Printer.HEADER_HOME;
import static printer.Printer.HEADER_LOGIN;
import static printer.Printer.HEADER_SIGN_UP;
import static printer.Printer.LIST_HOME0;
import static printer.Printer.LIST_HOME1;
import static printer.Printer.LIST_HOME2;
import static printer.Printer.MESSAGE_DOUBLE_ID;
import static printer.Printer.MESSAGE_NO_ID;
import static printer.Printer.MESSAGE_SUCCESS_LOGOUT;
import static printer.Printer.MESSAGE_SUCCESS_SIGNUP;
import static printer.Printer.MESSAGE_WRONG_INPUT;
import static printer.Printer.MESSAGE_WRONG_PW;
import static printer.Printer.clearCmd;
import static printer.Printer.print;
import static printer.Printer.println;

import java.util.Scanner;

import application.AdminLogic;
import application.UserLogic;
import entity.Order;
import entity.Product;
import entity.User;
import presentation.AdminUI;
import presentation.UserUI;
public class App {
    //클래스 전체에 공유
    static Scanner scanner = new Scanner(System.in);
    static String message = "";
    static UserLogic userLogic = UserLogic.getInstance();//객체를 싱글톤으로 생성
    static AdminLogic adminLogic = AdminLogic.getInstance();
    static UserUI userUI = new UserUI();
    static AdminUI adminUI = new AdminUI();

    public static void main(String[] args) {
        initData();
        while (true) {
            clearCmd();
            println(BLANK + message);
            println(BLANK + HEADER_HOME);
            println(BLANK + LIST_HOME1);
            println(BLANK + LIST_HOME2);
            println(BLANK + LIST_HOME0);
            println(BLANK + FOOTER);
            print(BLANK + ENTER_TASK_NUM);
            switch (scanner.nextLine()) {
                case "1" -> signUp();
                case "2" -> login();
                case "0" -> System.exit(0);
                default -> message = MESSAGE_WRONG_INPUT;
            }
        }
    }
     static void login() {
        clearCmd();
        println(BLANK + HEADER_LOGIN);
        print(BLANK + ENTER_ID);
        String id = scanner.nextLine();
        print(BLANK + ENTER_PW);
        String pw = scanner.nextLine();
        if(id.startsWith(ADMIN_PREFIX)){ //id 시작이  admin_ 시작하면 관리자로 가입
            try {
                User user = adminLogic.login(id, pw);
                adminUI.adminApp(user);
                message = MESSAGE_SUCCESS_LOGOUT;
            } catch (Exception e) {
               if(e.getMessage().equals(EXCEPTION_NO_ID)){
                    message = MESSAGE_NO_ID;
               }else if(e.getMessage().equals(EXCEPTION_WRONG_PW)){
                    message =  MESSAGE_WRONG_PW;
               } else{
                    message =  MESSAGE_WRONG_INPUT;
               }
            }
        }else{
            try {
                User user = userLogic.login(id, pw);
                userUI.userApp(user);
                message = MESSAGE_SUCCESS_LOGOUT;
            } catch (Exception e) {
               if(e.getMessage().equals(EXCEPTION_NO_ID)){
                    message = MESSAGE_NO_ID;
               }else if(e.getMessage().equals(EXCEPTION_WRONG_PW)){
                    message =  MESSAGE_WRONG_PW;
               } else{
                    message =  MESSAGE_WRONG_INPUT;
               }
            }
        }

    }
     static void signUp() {
        clearCmd();
        println(BLANK + HEADER_SIGN_UP);
        print(BLANK + ENTER_NAME);
        String name = scanner.nextLine();
        print(BLANK + ENTER_ID);
        String id = scanner.nextLine();
        print(BLANK + ENTER_PW);
        String pw = scanner.nextLine();
        if(id.startsWith(ADMIN_PREFIX)){ //id 시작이  admin_ 시작하면 관리자로 가입
            try{
                adminLogic.signUp(name, id, pw);
                message = MESSAGE_SUCCESS_SIGNUP; //관리자 가입 환영메시지
            }catch(Exception e){
                if(e.getMessage().equals(EXCEPTION_DOUBLE_ID)){
                    message = MESSAGE_DOUBLE_ID;
               }else{
                    message =  MESSAGE_WRONG_INPUT;
               }
            }
        }else{
            try {
                userLogic.signUp(name, id, pw);
            } catch (Exception e) {
               if(e.getMessage().equals(EXCEPTION_DOUBLE_ID)){
                    message = MESSAGE_DOUBLE_ID;
               }else{
                    message =  MESSAGE_WRONG_INPUT;
               }
            }
        }


    }
    private static void initData() {//더미데이터
        User user1 = userLogic.signUp("1", "1", "1");
        User user2 = userLogic.signUp("2", "2", "2");
        User user3 = userLogic.signUp("3", "3", "3");
        User auser1 = adminLogic.signUp("a1", ADMIN_PREFIX+"1", "a1");
        User auser2 = adminLogic.signUp("a2", ADMIN_PREFIX+"2", "a2");
        adminLogic.addProduct("p1", "상품1", 6500);
        adminLogic.addProduct("p2", "상품2", 21000);
        adminLogic.addProduct("p3", "상품3", 70);
        Product p1 = userLogic.getProductByProductId("p1");
        Product p2 = userLogic.getProductByProductId("p2");
        Product p3 = userLogic.getProductByProductId("p3");
        Order o1 = userLogic.makeOrder(user1);
        userLogic.addToOrder(user1, o1, p2, 5);
        userLogic.addToOrder(user1, o1, p1, 1);
        userLogic.addToOrder(user1, o1, p3, 9);
        Order o2 = userLogic.makeOrder(user2);
        userLogic.addToOrder(user2, o2, p1, 20);
        userLogic.addToOrder(user2, o2, p3, 1);
        Order o3 = userLogic.makeOrder(user3);
        adminLogic.removeOrder(o3.getOrderId());
        
    }



    
}
