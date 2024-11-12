package a1112;

import java.util.Scanner;

public class Scan1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Scanner 객체를 생성 System.in(콘솔)에서 입력받는다.
        //  알트 쉬프트 O
        int num = scan.nextInt();
        System.out.println(num);
    }
    
}
