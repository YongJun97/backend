package practice.hospital2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        
        CostomerManager cm = new CostomerManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t 어서오세요. JAVA 병원 입니다.");
                        // 탭했을때의 공간만큼 위 아래 간격
    //  조건이 거짓이 나올 때 까지 반복
        while (true) {
            System.out.println("\n========= 메인 메뉴 =========\n");
            System.out.println("1. 환자 등록");
            System.out.println("2. 등록 정보 보기");
            System.out.println("3. 관리자 메뉴");
            System.out.println("0. 종료\n");
            System.out.println("입력 > ");
            int choice = -1;

            try{
                choice = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("잘못된 입력입니다. 숫자만 입력 해주세요.");
                sc.next();
                continue;
            }

            switch (choice) {  // try문 에서 입력받은 정수값 choice = sc.nextInt();
                case 1:
                    cm.costomerAppointment(); 
                    // 정수값 1을 입력 했을 때 cm(CostomerManager) 객체안의 매서드 costomerAppointment() 를 호출 하겠다.
                    break;
                case 2:
                    cm.costomerPrint(); // 목록을 조회하는 메서드
                    break;
                case 3:
                    if(!checkAdminPw()){
                        System.out.println("비밀번호가 틀렸습니다.");
                        break;
                    }
                    cm.adminMenu();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;

                default:
                    break;
            }
                    
                    
                    
                    
                    
                    
        }
    }
                    
        private static boolean checkAdminPw() {
            Scanner sc = new Scanner(System.in);
            System.out.println("관리자 비밀번호를 입력하세요: ");
            String adminPw = sc.nextLine();
            return "admin1234".equals(adminPw); // 입력받은 adminPw 가 admin1234 와 같을 때
        }
}
