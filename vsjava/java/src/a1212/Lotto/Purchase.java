package a1212.Lotto;

import java.util.Scanner;

public class Purchase {
    String customerNum = ""; //사용자가 입력할 로또번호 집합
    public void perchaseQuestion(Membership m) {
           Scanner sc = new Scanner(System.in);

        System.out.println("\n[INFO]" + m.name + "님, 안녕하세요  "
        + "\n로또를 구매하시겠습니까?"
        +"\n [1] 예 \t [2] 아니오");
        String answer ="";
        for(;;){
            System.out.print("\n입력 : ");
            answer = sc.next();
          
            if(answer.equals("1") || answer.equals("예")) {
                letsLottery(m); //로또번호 입력 메서드
                    System.out.println("\n=================================================================");
                    break;            
                }else if(answer.equals("2") || answer.equals("아니요")){
                    System.out.println("\n[ERROR] 로또 구매가 종료되었습니다.");
                    System.exit(0);   
                }else {
                    System.out.println("\n[ERROR] 잘못된 입력입니다. 다시 입력해주세요.");
                }
            }
        
        }
    
        private void letsLottery(Membership m) {
            Scanner sc = new Scanner(System.in);
        System.out.println("\n[INFO] 1의 자리 숫자로 총 6개의 로또 번호를 입력해주세요");

        String num1 = "";
        String num2 = "";
        String num3 = "";
        String num4 = "";
        String num5 = "";
        String num6 = "";

        //1의 자리 숫자가 아니면 무한 반복
        for(;;){
            System.out.print("첫번째 번호 입력 : ");
            num1 = sc.next();
            if(num1.length() != 1 ){
                System.out.println("1의 자리 숫자만 입력해 주세요(0~9)");
            }else{
                break;
            }
        }
        for(;;){
            System.out.print("두번째 번호 입력 : ");
            num2 = sc.next();
            if(num2.length() != 1 ){
                System.out.println("1의 자리 숫자만 입력해 주세요(0~9)");
            }else{
                break;
            }
        }
        for(;;){
            System.out.print("세번째 번호 입력 : ");
            num3 = sc.next();
            if(num3.length() != 1 ){
                System.out.println("1의 자리 숫자만 입력해 주세요(0~9)");
            }else{
                break;
            }
        }
        for(;;) {
            System.out.print("네번째 번호 입력 : ");
            num4 = sc.next();
            if(num4.length() != 1) {
                System.out.println("1의 자리 숫자만 입력해주세요. ( 0 ~ 9 )");
            }else {
                break;
            }         
        }
            
        for(;;) {
            System.out.print("다섯번째 번호 입력 : ");
            num5 = sc.next();
            if(num5.length() != 1) {
                System.out.println("1의 자리 숫자만 입력해주세요. ( 0 ~ 9 )");
            }else {
                break;
            }         
        }
            
        for(;;) {
            System.out.print("여섯번째 번호 입력 : ");
            num6 = sc.next();
            if(num6.length() != 1) {
                System.out.println("1의 자리 숫자만 입력해주세요. ( 0 ~ 9 )");
            }else {
                break;
            }         
        }
        
        }

}
