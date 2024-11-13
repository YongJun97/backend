package a1113;

import java.util.Scanner;

public class Ex08 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("정수를 입력하세요 : ");
            int num = scan.nextInt();

            if(num % 2 == 0){
                System.out.println(num + "은 짝수입니다.");
            }else{
                System.out.println(num + "은 홀수입니다.");
            }
            
            
        }
}
