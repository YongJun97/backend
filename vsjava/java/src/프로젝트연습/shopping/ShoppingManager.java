package 프로젝트연습.shopping;

import java.util.ArrayList;



public class ShoppingManager {
    
    private static ArrayList<Shopping> sho; // 장바구니 목록

    public ShoppingManager(){
        sho = new ArrayList<>();
    }

    public void paymentor() {
        System.out.println("1.결제하기");
        System.out.println("2.장바구니 담기");
        int choice = -1;
        switch (choice) {
            case 1:
                System.out.println("결제가 완료 되었습니다.");
                break;
            case 2:
                System.out.println("장바구니에 담겼습니다!");
                break;
            default:
                break;
        }


    }
    
}
