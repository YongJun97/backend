package a1113;

import java.util.Scanner;

public class Ex12 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("입력 : ");
            int num = scan.nextInt();
            System.out.print("입력 : ");
            int num1 = scan.nextInt();
            System.out.print("입력 : ");
            int num2 = scan.nextInt();
            int sum = num + num1 + num2;
            // double num3 = (double)(num + num1 + num2)/ 3;
            
            
            System.out.println("총합 :"+sum);
            System.out.printf("출력 :%.1f\n", (float)sum/ 3);
            // System.out.print("나머지 :"+num3);
        }
}
