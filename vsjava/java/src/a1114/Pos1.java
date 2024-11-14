package a1114;

import java.util.Scanner;

public class Pos1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하세요: ");
        int aa = scanner.nextInt();
        // int i = 0;
        // if(i<=aa){
        //     System.out.println("양수");
        // }else{
        //     System.out.println("음수");
        // }
        if(aa > 0){
            System.out.println("양수");
        }else if(aa < 0){
            System.out.println("음수");
        }else{
            System.out.println("0입니다.");
        }
    }
}
