package practice;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("환전 할 금액을 입력 해주십시오.\n>> ");
        
        int change = Integer.parseInt(sc.nextLine());
        

        System.out.println("50000원 권" + (change / 50000) + "개");
        change = change%50000;
        System.out.println("10000원 권" + (change / 10000) + "개");
        change = change%10000;
        System.out.println("5000원 권" + (change / 5000) + "개");
        change = change%5000;
        System.out.println("1000원 권" + (change / 1000) + "개");
        change = change%1000;
        System.out.println("500원 권" + (change / 500) + "개");
        change = change%500;
        System.out.println("100원 권" + (change / 100) + "개");
        change = change%100;
        System.out.println("50원 권" + (change / 50) + "개");
        change = change%50;
        System.out.println("10원 권" + (change / 10) + "개");
        change = change%10;
    }
}
