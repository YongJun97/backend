package a1114;

import java.util.Scanner;

public class Switch7 {
    public static void main(String[] args) {
        // 사용자로부터 두 숫자와 연산자를 입력받아 계산 결과를 출력하는 프로그램을 작성하세요.
        // 연산자는 +,-,*,/ 중 하나입니다

        Scanner scanner = new Scanner(System.in);
        System.out.print("첫번째 숫자를 입력하시오 : ");
        double num1 = scanner.nextDouble();
        System.out.println("연산자를 입력하시오(+,-,*,/): ");
        char oper = scanner.next().charAt(0); //입력된 첫글자(인덱스0번)문자삽입
        double num2 = scanner.nextDouble();

    switch(oper){
        case '+' :
        System.out.println("결과: " +(num1+num2));
        break;
        case '-':
        System.out.println("결과: " +(num1-num2));
        break;
        case '*':
        System.out.println("결과"+(num1*num2));
        break;
    case '/':
        if(num2 != 0){
            System.out.println("결과: " +(num1/num2));
        }else{
            System.out.println("0으로는 나눌 수 없습니다 ");
        }
        break;
    default:
        System.out.println("잘못된 연산자 입니다.");
    }
    scanner.close();

    }
}
