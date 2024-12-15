package practice;

import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 시급
        int a = 9860;
        

        // 일급
        System.out.println("근무시간을 입력 해 주십시오 현재 최저 시급은 9860원 입니다.");
        int b = sc.nextInt();
        int c = a*b;
        System.out.println("일급은 총" + c + "원 입니다.");
        

        System.out.println("계산된 시급을 바탕으로 주급을 계산 합니다.");
        System.out.println("총 근무일 을 입력 하여 주십시오.\n>>");
        
        // 주급
        int d = sc.nextInt();
        int r = c*d;
        System.out.println("계산된 주급은"+ r + "원 입니다.");

        // 월급
        System.out.println("계산된 시급을 바탕으로 월급을 계산 합니다.\n 월 총 근무일수 를 입력 하여 주십시오.\n>>");
        int q = sc.nextInt() * c;
        System.out.println("월급은 "+ q + " 원 입니다.");
        
    }
}
