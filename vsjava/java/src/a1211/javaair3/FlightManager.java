package a1211.javaair;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class FlightManager {
    private static ArrayList<Flight> flights; // 항공편정보를 저장 ArrayList
    private static ArrayList<Passenger> passengers; // 예약된 승객정보를 저장 ArrayList
    // 승객을 키로하고 , 예약된 항공편을 값으로 가지는 Map
    private static Map<String, Flight> reservationMap = new HashMap<>();

    private static FileC fc = new FileC();

    Scanner sc = new Scanner(System.in);

    public FlightManager(){
        flights = new ArrayList<>();
        flights.add(new Flight("제주","11:55", 78000, false));
        flights.add(new Flight("이스탄불","17:10",1200000,true));
        flights.add(new Flight("방콕","21:35",280000,true));

        passengers = new ArrayList<>();
        Flight sf = flights.get(0);
        reservationMap.put("테스트",sf);

    }
    public String airplane = "                       |                      \n" + "                      _|_                     \n" + "                    /_____\\                  \n" + "                   /oo   oo\\                 \n" + " \\_________________\\       /_________________/\n" + "  `-------|---|-----\\_____/-----|---|-------'\n" + "         ( ) ( )  O|OOo|oOO|O  ( ) ( )   \n";

    public void displayFlightList(String str) {
        // 항공편 목록 출력 -> flight 에서 toString 이용해서
        System.out.println("================== " + str + " ==================");
        int count =1;
        for(Flight flight : flights){
            System.out.println(count+ "" +flight); // flight.toString() 투스트링은 생략된 형태
            count++;
        }
        System.out.println("===============================================");
    }

    public void bookFlight() throws InterruptedException{
        // 국제선 - 사용자이름, 생년월일 받아서 나이 확인하고 만 15세 미만 예약거절
        for(;;){ // 무한루프
            displayFlightList("항공편예매");
            System.out.println("예매할 항공편 입력 > ");
            try{
                int bookNum = Integer.parseInt(sc.next());
                // 입력 받은 번호는 flight.get(Booknum-1);
                if(bookNum > flights.size() || bookNum < 1){
                    System.out.println("잘못된 입력입니다.");
                    continue;
                    // 유효하지 않은 입력을 받은 경우 루프 다음을 반복
                    // 사용자에게 입력을 재요청
                }
                System.out.println("선택한 항공편");
                System.out.println("===============================================");
                System.out.println(bookNum + "" + flights.get(bookNum - 1));
                System.out.println("===============================================");
                Flight sf = flights.get(bookNum -1); // 선택한 항공편 sf로 저장
                if(flights.get(bookNum -1).getInternationalFlight()){ // 국제선을 선택하면
                    // 국제선을 선택 했을때
                    System.out.println("국제선은 만 15세 이상 예매가능");
                    passengerInfo(sf);
                    }else{
                    passengerInfo(sf);
                    }
                if(passengers != null && !passengers.isEmpty()){
                    String seatNum = Integer.toString(seatSelection(sf)); // 좌석                }
                    passengers.get(passengers.size()-1).setSeat(seatNum);
                    System.out.println("예약중입니다.");
                    Thread.sleep(2000);
                    reservationMap.put(passengers.get(passengers.size()-1).getName(),sf);
                    System.out.println("예약완료");


                    }
                    }catch(NumberFormatException e){
                                            System.out.println("잘못된 입력입니다.");
                    }
                                    
                    }
                }

                private int seatSelection(Flight flight) {
                            int seatNum = -1;
        while (true) {
            try{
                System.out.println("========================================");
                flight.seatToString(); //빈좌석 보이는 print
                System.out.println("좌석을 선택하세요");
                System.out.print("선택>");
                int seatInt = sc.nextInt() - 1 ;
                sc.nextLine();
                if(seatInt + 1 < 1 || seatInt + 1 > 20){//좌석이 1~20인지
                    System.out.println("존재하지 않는 좌석입니다.");
                }else if(flight.getSeats().get(seatInt).equals("XX")){
                    System.out.println("이미 예약된 좌석입니다.");
                }else{
                    //좌석이 비어있는 경우 XX를 넣는다.
                    flight.getSeats().set(seatInt, "XX");
                    System.out.println("좌석 선택이 완료되었습니다.");
                    seatNum = seatInt;
                    break;
                }

                }catch(InputMismatchException e){
                    System.out.println("잘못된 입력입니다.");
                    sc.nextLine();
                }
                }
                return seatNum;
                }
                    
                private void passengerInfo(Flight flight) { // 사용자 입력해서 예약
                    System.out.println("예매자 정보를 입력하세요");
                    System.out.println("이름: ");
                    String name = sc.next();
                    System.out.println("생년월일(6자리): ");
                    try{
                        int birthDate = Integer.parseInt(sc.next());
                        Passenger p = new Passenger(name, birthDate);
                        if(!p.man15(p) && flight.getInternationalFlight()){
                            // 왼쪽 과 오른쪽 true 이여야만 실행
                            // 만 15세 나이검증
                            System.out.println("만 15세 미만이므로 국제선 예약이 불가합니다.");
                        }else{
                            System.out.println("결제 비밀번호: ");
                            String pw = sc.next();
                            p = new Passenger(name, birthDate, pw);
                            passengers.add(p);//항공예약명단에 추가
                        }

                    }catch(DateTimeException e){
                        System.out.println("생년월일을 6자리로 입력해주세요 ex.010225");
                    }
                    
                }

                public void checkReservation() {//예약확인
                    int index = search("예약 확인");
                    checkPassword(index);
                }
            
                private void checkPassword(int index) {
                   for(;;){
                    if(index !=-1){
                        System.out.print("결제 비밀번호: ");
                        String pw = sc.next();
                        System.out.println();
                        if(passengers.get(index).getPw().equals(pw)){
                            System.out.println("비밀번호가 일치합니다.");
                            System.out.println(ticketPrint(reservationMap, passengers.get(index).getName()));
                            break;
                        }else{
                            System.out.println("비밀번호가 일치하지 않습니다.");
                        }
            
                    }else{
                        System.out.println("일치하는 이름이 없습니다.");
                        break;
                    }
            
                   }
            
                }
            
                String ticketPrint(Map<String, Flight> reservationMap, String name) {
                    int index = -1;
                    if(passengers !=null){
                        for(int i=0; i < passengers.size();i++){
                            if(passengers.get(i).getName().equals(name)){
                                index = i;
                            }
                        }
                    }
                    int seat = Integer.parseInt(passengers.get(index).getSeat())+1;
                    return  "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n\n" +
                            "\t" + name + "님의 티켓정보" +
                            "| 좌석 : " + seat + "번\n"+
                            "." + reservationMap.get(name) + "\n\n" +
                            "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
                }
            
                private int search(String str) {//이름을 검색받아서 인텍스 번호 반환
                    System.out.println("===================== " + str + " =====================");
                    System.out.print("예약자 이름: ");
                    String name = sc.next();
                    sc.nextLine();
            
                    int index = -1;
                    if(passengers != null){
                        for (int i=0; i < passengers.size(); i++){
                            if(passengers.get(i).getName().equals(name)){
                                index = i;
                            }
                        }
                    }
            
                    return index;
                }

}
