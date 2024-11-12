package a1112;

import java.util.Scanner;

public class Scan8 {
    public static void main(String[] args) {
        // 입력예시
        //  A
        //  b
        // 출력: b A
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("x 값 입력: ");
		String a = scanner.next();

		System.out.print("y 값 입력: ");
		String b = scanner.next();
                        

        System.out.print(b+" "+a);
        
        
    }
}
