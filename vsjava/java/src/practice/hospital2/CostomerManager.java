package practice.hospital2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CostomerManager {
    private static ArrayList<Costomer> costomer; // 목록
    Scanner sc = new Scanner(System.in);
    public CostomerManager(){
        costomer = new ArrayList<>(); // 비어있는 ArrayList 객체를 생성
        costomer.add(new Costomer("곽두팔", "010-1234-5678", "경기도 화성시 봉담읍", "감기몸살", "12:30"));
        // 비어있는 ArrayList 객체에  ("곽두팔", "010-1234-5678", "경기도 화성시 봉담읍", "감기몸살", "12:30")
        //  객체를 .add 를 사용하여 삽입

    }
    public void costomerAppointment() {
        System.out.println("==========환자 등록==========");
        System.out.println("이름 : ");
        String name = sc.next();
        sc.nextLine();  // 줄바꿈을 위해 씀
        
        System.out.println("전화번호(-포함): ");
        String phone = sc.next();
        sc.nextLine();

        System.out.println("주소: ");
        String address = sc.nextLine();
        sc.nextLine();
        
        System.out.println("진료 내용: ");
        String disease = sc.nextLine();
        sc.nextLine();

        System.out.println("예약 시간: ");
        String time = sc.next();
        sc.nextLine();
        
        costomer.add(new Costomer(name, phone, address, disease, time));
        System.out.println("접수중입니다.");
        System.out.println("\n" + name + "님, 접수가 완료 되었습니다.");
    }
    public void costomerPrint() {
         boolean costomerAppoint = false;
         System.out.println("검색할 환자의 이름 : " );
         String name = sc.next();
         for(Costomer list : costomer){ // Costomer 객체리스트(costomer) 안에 있는 모든 요소를 하나씩 꺼내어 list 라는 변수에 담아 반복 한다 (여기서 반복한다는 표현은 담는 동작을 반복 한다는 뜻 이다)
            
            if(list.getName().equalsIgnoreCase(name)){ //리스트에 담겨 있는 name 과 입력받은 name이 같을때 (IgnoreCase는 영어의 대소문자 구분을 없애는 매서드)
                costomerAppoint = true; 
                System.out.println("등록정보: "+ list.getDisease() + " " + list.getTime());
            }
         }
         if(!costomerAppoint){
            System.out.println("정보가 존재하지 않습니다.");
             return;
         }
    }
    public void adminMenu() {
        while (true) {
            System.out.println("\n======= 관리자 메뉴 =======\n");
            System.out.println("1. 환자 등록 목록");
            System.out.println("2. 환자 등록 삭제");
            System.out.println("3. 환자 정보 수정");
            System.out.println("4. 메인으로 돌아가기\n");
            System.out.println("입력 > ");

            int choice = -1;
            try{
                choice = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("잘못된 입력 입니다. 숫자만 입력 하세요.");
                sc.next();
                continue;
            }
            switch (choice) {
                case 1:
                    printAll(); // 모든 환자 조회
                    break;
                case 2:
                    cancelAppoint(); // 환자 등록 삭제
                    break;
                case 3:
                    updateCostomer(); // 환자 등록 정보수정
                    break;
                case 4:
                    return;
                    // 메인메뉴 에서 3번을 선택하면 adminMenu() 실행
                    // 4를 선택하면 return을 통해 adminMenu() 의 실행을 종료하고
                    // 호출된 위치(메인메뉴) 로 돌아옵니다.
                    
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력하여 주십시오.");
                    break;
            }


        }
    }


    private void printAll() {
        for(Costomer aa : costomer){
            System.out.println(aa.toString());
        }        
        if(costomer.isEmpty()){ // costomer 가 isEmpty() 리스트가 아무것도 없으면
            System.out.println("환자가 존재하지 않습니다.");
            return;
        }
    }

    private void cancelAppoint() {
        System.out.println("삭제하고 싶은 환자 이름 : ");
        String cancelNmae = sc.next();
        boolean costomerFound = false;
        for(Costomer aa : costomer){
            if(aa.getName().equalsIgnoreCase(cancelNmae)){
                costomer.remove(aa);     //입력받은 이름과 리스트에 있는 이름이 일치하면 costomer 안의 aa를 삭제(remove)
                System.out.println("삭제중입니다.");
                System.out.println("\n" + cancelNmae + "님의 정보 삭제");
                costomerFound = true;
                break;
            }
        }             
        if(!costomerFound){
            System.out.println("존재하지 않습니다.");
        }                             
    }

    private void updateCostomer() {
        boolean costomerFound = false;
        System.out.println("정보를 수정할 환자 이름: ");
        String name = sc.next();
        for(Costomer aa : costomer){
            if(aa.getName().equals(name)){
                costomerFound = true;
                System.out.println("수정하고 싶은 정보를 선택하세요.");
                System.out.println("1. 전화번호 | 2. 주소 | 3. 예약 시간");
                System.out.println("입력> ");
                String updateNum = sc.next();
                
                if(updateNum.equals("1")){ // 입력받은 updateNum이 1과 같다면 전화번호수정> 출력 후 
                    System.out.println("전화번호수정>"); // updatePhone 이라는 변수에 수정할 번호를 입력받음
                    String updatePhone = sc.next(); // 그리고 aa리스트에 입력받은 전화번호를 setPhone으로 수정
                    aa.setPhone(updatePhone);
                    System.out.println(name+" 님의 전화번호가 수정 되었습니다.");
                    break;
                }else if(updateNum.equals("2")){
                    System.out.println("주소 수정>");
                    sc.nextLine();
                    String updateAddress = sc.nextLine();
                    aa.setAddress(updateAddress);
                    System.out.println(name+" 님의 주소가 수정 되었습니다.");
                    break;
                }else if(updateNum.equals("3")){
                    System.out.println("예약시간 수정> ");
                    String updateTime = sc.next();
                    aa.setTime(updateTime);
                    System.out.println(name + " 님의 예약 시간이 수정 되었습니다.");
                    break;
                }else{
                    System.out.println("잘못 입력했습니다.");
                    break;
                }
            }
        }
        if(!costomerFound){
            System.out.println("존재하지 않습니다.");
        }


    }

                
                
                





}
