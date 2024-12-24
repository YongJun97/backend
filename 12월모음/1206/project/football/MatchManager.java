package project.football;

import java.util.ArrayList;
import java.util.Scanner;

public class MatchManager {
    private ArrayList<Match> matches;
    private ArrayList<Reservation> reservations;
    private Scanner scanner;

    public MatchManager() {
        this.matches = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.scanner = new Scanner(System.in); 
        
        matches.add(new Match("맨체스터 유나이티드", "리버풀", "2024-09-10", "21:00", "1"));
        matches.add(new Match("첼시", "웨스트햄", "2024-09-12", "19:00", "2"));
        matches.add(new Match("토트넘 핫스퍼", "아스널", "2024-09-15", "20:00", "3"));
        matches.add(new Match("맨체스터 시티", "뉴캐슬", "2024-09-16", "21:00", "4"));
      
    }

    public void menu() {
        while (true) {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("1. 경기 목록 조회");
            System.out.println("2. 경기 예매");
            System.out.println("3. 예매 내역 확인");
            System.out.println("4. 예매 취소");
            System.out.println("5. 종료");
            System.out.print("선택> ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    showMatches();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    showReservations();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private void showMatches() {
        System.out.println("예매 가능한 경기 목록입니다.");
        System.out.println("--------------------------------------------------------------------------");
        if (matches.isEmpty()) {
            System.out.println("현재 예매 가능한 경기가 없습니다.");
            return;
        }
        
        for (Match match : matches) {
            System.out.println("<"+ match.getTeam1() + " vs " + match.getTeam2() + ">"+ " "+
                               "날짜: " + match.getDate() + ", " +
                               "시간: " + match.getTime() + ", " + 
                               "경기번호: " + match.getMatchNum()
                               );
                               
        }
    }

    private void makeReservation() {
        System.out.print("예매할 경기의 경기번호를 입력하세요: ");
        String matchNum = scanner.nextLine();

        Match selectedMatch = null;

        for (Match match : matches) {
            if (match.getMatchNum().equals(matchNum)) {
                selectedMatch = match;
                break;
            }
        }

        if (selectedMatch != null) {
            System.out.print("사용자 이름을 입력하세요: ");
            String userName = scanner.nextLine();
            System.out.print("나이를 입력하세요: ");
            String userAge = scanner.nextLine();
            System.out.print("전화번호를 입력하세요: ");
            String userPhone = scanner.nextLine();
            System.out.print("비밀번호를 설정해주세요: ");
            String password = scanner.nextLine();
            User user = new User(userName, userAge, userPhone);
            Reservation reservation = new Reservation(matchNum, userName, userAge, userPhone, password);
            reservations.add(reservation);
            System.out.println("예매가 완료되었습니다.");
            
        } else {
            System.out.println("잘못된 경기 번호 입니다.");
            
        }
    }

    private void showReservations() {
        System.out.print("예매 내역을 확인할 경기 번호를 입력하세요: ");
        String matchNum = scanner.nextLine();
        boolean found = false;
        for (Reservation reservation : reservations) {
            if (reservation.getMatchNum().equals(matchNum)) {
                System.out.print("비밀번호를 입력하세요: ");
                String password = scanner.nextLine();
               if(reservation.getPassword().equals(password)){
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("예매자 이름: " + reservation.getUserName() + ", 나이: " + reservation.getUserAge() + ", 전화번호: " + reservation.getUserPhone());
                System.out.println("--------------------------------------------------------------------------");
                found = true;
               }else{
               System.out.println("비밀번호를 확인해주세요.");
               break;
               }
            }else{
                System.out.println("해당 경기의 예매 내역이 없습니다.");
                break;
            }
        }
    }

     private void cancelReservation() {
        System.out.print("취소할 경기 번호를 입력하세요: ");
        String matchNum = scanner.nextLine();
        boolean found = false;
        for(Reservation reservation : reservations){
            if (reservation.getMatchNum().equals(matchNum)) {
                found = true;
                System.out.println("비밀번호를 입력하세요: ");
                String password = scanner.nextLine();
                if(reservation.getPassword().equals(password)){
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("예매자 이름: " + reservation.getUserName() + ", 나이: " + reservation.getUserAge() + ", 전화번호: " + reservation.getUserPhone());
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("예매를 취소하시겠습니까? 1. 예 2. 아니오");
                    String answer = scanner.nextLine();
                    if (answer.equals("1")) {
                        reservations.remove(reservation);
                        System.out.println("예매가 취소되었습니다.");
                        break;
                    }
                    if(answer.equals("2")){
                        System.out.println("예매가 취소되지 않았습니다.");
                        break;
                    }
                }else{
                System.out.println("비밀번호를 확인해주세요.");
                break;}
            }else{
            System.out.println("해당 경기의 예매 내역이 없습니다.");
            break;
        }
        }
    }

  
   

 
    
}