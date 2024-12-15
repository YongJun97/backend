package practice;

import java.util.Scanner;

public class Meter {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.println("거리를 입력");
        int i = Integer.parseInt(sc.nextLine());
        double k = 0;
        if(i<1000){
            System.out.println(i + "m");
        }else{
            k=i/1000.0;
            System.out.println(k + "km");
        }

    }
}
