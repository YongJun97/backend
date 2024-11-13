package a1113;

import java.util.Scanner;

public class Ex07 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("첫번째 정수를 입력하세요 : ");
            int a = scan.nextInt();
            System.out.print("두번째 정수를 입력하세요 : ");
            int b = scan.nextInt();
            
            
            
            System.out.println(a+"+"+b+" = "+(a+b)); 
            System.out.println(a+"-"+b+" = "+(a-b)); 
            System.out.println(a+"*"+b+" = "+(a*b)); 
            System.out.println(a+"/"+b+" = "+(a/b)); 
            System.out.println(a+"%"+b+" = "+(a%b)); 


            System.out.printf("%d + %d = %d\n",a,b,(a+b));
            System.out.printf("%d - %d = %d\n",a,b,(a-b));
            System.out.printf("%d * %d = %d\n",a,b,(a*b));
            System.out.printf("%d / %d = %d\n",a,b,(a/b));
            System.out.printf("%d %% %d = %d\n",a,b,(a%b));
        }
}
