package 프로젝트연습.shopping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingManager sm = new ShoppingManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("==============코팡에 오신걸 환영합니다==============");
        while (true) {
            System.out.println("구매할 상품을 선택하여 주십시오");
            System.out.println("1.마우스");
            System.out.println("2.등산스틱");
            System.out.println("3.케이블");
            System.out.println("4.세제");
            System.out.println("5.모니터");
            System.out.println("6.태블릿");
            System.out.println("7.물");
            System.out.println("8.종료");
            int choice = -1;
            try{
                choice = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요");
                sc.next();
                continue;
            }
            
            switch (choice) {
                case 1:
                    sm.paymentor();
                    break;
            
                default:
                    break;
            }
        
        }
        





    }
}
