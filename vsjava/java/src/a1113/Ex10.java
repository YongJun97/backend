package a1113;

import java.util.Scanner;

public class Ex10 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("정수를 입력하세요 : ");
            int num = scan.nextInt();
            int num1 = 0;
            
            for(int i=1; i<=num;i++){
                num1 += i;
                // num1 = num + i;
                
                
            }
            System.out.println("1부터"+num+"합은"+ num1);
            // for문 안에다가 쓰면 100번 찍힘
            
        }
}
