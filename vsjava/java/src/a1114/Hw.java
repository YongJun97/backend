package a1114;

import java.util.Scanner;

public class Hw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원하시는 월을 입력하세요: " );
        int mo = scanner.nextInt();
        
        switch(mo){
            case 3:
            case 4:
            case 5:
                System.out.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("가을");
                break;
            default:
                System.out.println("겨울");
                // break;
        }
    }
}
