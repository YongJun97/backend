package project2.Hotel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class HotelManager {
    private static LocalDate today = LocalDate.now();
    private static Reserve[] reserve;
	private static Room[][] room = new Room[4][20];
	private static String bookAvailable = "○ ";
	private static String checkIn= "X ";
	private static String bookUnable= "● ";

    public static void roomSet(){
        for(int i = 0; i < room.length; i++){
            for(int j = 0; j < room[i].length; j++){
                int roomNum = (i + 2) * 100 + (j + 1);
                room[i][j] = new Room(roomNum);
            }
        }
    }

    private static void showRoom() {
        System.out.println("오늘 날짜: " + today);
        System.out.println("○: 예약가능 ●: 예약불가능 X: 체크인");
        for(int i = 0; i < room.length; i++){
            for(int j = 0; j < room[i].length; j++){
                String todayStatus = room[i][j].getRoomStatus();
                if(todayStatus.equals("체크인")){
                    System.out.println((i + 2) * 100 + (j + 1) + "호:" + checkIn + "  ");
                }else if(todayStatus.equals("예약중")){
                    System.out.print((i + 2) * 100 + (j + 1) + "호:" + bookUnable + "  ");
                }else{
                    System.out.print((i + 2) * 100 + (j + 1) + "호:" + bookAvailable + "  ");
                }
            }System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        reserve = new Reserve[0];
        roomSet();
        
        boolean hm = true;
        while (hm) {
            System.out.println("1.현재 객실 보기 \n2.예약하기\n3.예약 내역 보기\n4.체크인\n5.체크아웃\n6.객실 정보 보기\n0.프로그램 종료\n");
            System.out.print("메뉴 입력>>");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("현재 객실 보기");
                    showRoom();
                    break;
                case 2: 
                    System.out.println("예약하기");
                    System.out.println("*날짜입력(6자리 숫자)를 입력하세요");
                    LocalDate inputDate = today;
                    boolean dateHm = true;
                    while(dateHm){
                        int date = sc.nextInt();
                        if(dateCheck(date)){
                            int year = 2000 + (date/10000);
                            int month = date % 10000/100;
                            int day = date % 100;
                            inputDate = LocalDate.of(year, month, day);
                            dateHm = false;
                        }else{
                            System.out.println("*잘못 입력했습니다. 다시 입력해주세요(6자리 숫자)");
                        }
                    }
                    System.out.println("*방선택(홀수:싱글룸/짝수:더블룸)");
                    System.out.println("-방번호 입력(201호 ~ 520호)");
                    int inputRoomNum = 0;
                    boolean roomHm = true;
                    while(roomHm){
                        inputRoomNum =sc.nextInt();
                        int roomFloor = inputRoomNum / 100;
                        int roomNum = inputRoomNum / 100;
                        if(2 <= roomFloor && roomFloor <= 5 && 0 < roomNum && roomNum <= 20){
                            roomHm = false;
                        } else {
                            System.out.println("잘못 입력했습니다. 다시 입력해주세요(201호 ~ 520호)");
                        }
                    }
                    if(reserveCheck(inputDate, inputRoomNum)){
                        System.out.println("*예약자 정보 입력");
                        System.out.print("-이름: ");
                        String inputName = sc.next();
                        System.out.print("-폰번호:");
                        String inputPhone = sc.next();
                        reservation(new Reserve(inputDate, inputRoomNum, inputName, inputPhone), reserve);
                    }
                    break;
                case 3: 
                        System.out.println("예약 내역 보기");
                        System.out.println("1. 날짜선택 2. 방선택");
                        System.out.print("번호입력>>");
                        int input = sc.nextInt();
                        if(input == 1){
                            System.out.println("*날짜를 입력하세요.(6자리 숫자)");
                            int date = sc.nextInt();
                            if(dateCheck(date)){
                                int year = 2000 + (date/10000);
                                int month = date % 10000/100;
                                int day = date % 100;
                                inputDate = LocalDate.of(year, month, day);
                                reserveInputDate(inputDate);
                            }else{
                                System.out.println("잘못 입력했습니다.");
                            }
                        }else if(input == 2){
                            System.out.println("*방번호를 입력하세요.(201호 ~ 520호)");
                            reserveInputRoom(input);
                        }else{
                            System.out.println("잘못 입력했습니다.");
                        }
                        break;
                case 4: 
                        System.out.println("체크인");
                        System.out.println("1. 예약자 이름 입력하기  2. 방번호 입력하기");
                        System.out.print("번호 입력: ");
                        int checkIn = sc.nextInt();
                        if (checkIn == 1) {
                            System.out.print("이름 입력: ");
                            checkInName(sc.next());
                        } else if (checkIn == 2) {
                            System.out.print("*방번호를 입력하세요.(201호 ~ 520호)");
                            checkInRoom(sc.nextInt());
                        } else {
                            System.out.println("잘못 입력했습니다.");
                        }
                        break;
                case 5: 
                        System.out.println("체크아웃");
                        System.out.println("*방번호를 입력하세요.(201호 ~ 520호): ");
                        checkOut(sc.nextInt());
                        break;
                case 6: 
                        System.out.println("객실 정보 보기");
                        showRoomInformation();
                        break;        
                default:
                    System.out.println("프로그램 종료");
				    hm = false;
                    break;
            }
        }    
        
    }


    public static void checkOut(int roomNum) {
        int indexFloor = roomNum / 100 - 2;
        int indexNum = roomNum % 100 - 1;
        room[indexFloor][indexNum].setRoomStatus("빈방");
		room[indexFloor][indexNum].setGuest(new Guest("", ""));
		System.out.println(room[indexFloor][indexNum].toString());
		System.out.println("체크아웃 완료");
    }

    public static void showRoomInformation() {
        for (int i = 0; i < room.length; i++) {
			System.out.println((i + 2) + "층");
			for (int j = 0; j < room[i].length; j++) {
				System.out.println(room[i][j].toString());
			}
		}
    }

    public static void checkInRoom(int roomNum) {
        int indexFloor = roomNum / 100 - 2; 
		int indexNum = roomNum % 100 - 1;
		
		room[indexFloor][indexNum].setRoomStatus("체크인");
		System.out.println(room[indexFloor][indexNum].toString());
		System.out.println("체크인 완료");
    }

    public static void checkInName(String name) {
        for (int i = 0; i < reserve.length; i++) {
			if (reserve[i].getGuestName().equals(name)) {
				int roomNum = reserve[i].getReserveRoomNum();
				int indexFloor = roomNum / 100 - 2; 
				int indexNum = roomNum % 100 - 1;
				room[indexFloor][indexNum].setRoomStatus("체크인");
				System.out.println("체크인 완료");
			} else {
				System.out.println("예약내역이 없습니다.");
			}
		}
    }

    public static void reserveInputRoom(int input) {
        for (int i = 0; i < reserve.length; i++) {
			if (reserve[i].getReserveRoomNum() == input) {
				System.out.println(reserve[i].toString());
			} 
		}
		System.out.println("(○:예약가능  X:예약완료)");
		
		
		for (int j = 0; j < 30; j++) {
			LocalDate date = today.plusDays(j);
			LocalDate reservedDate = LocalDate.of(2022, 1, 1);

			if (reserve.length == 0) {
				System.out.print(date + ":" + bookAvailable + "  ");
			}
			
			for (int i = 0; i < reserve.length; i++) {
				if (reserve[i].getReserveRoomNum() == input) {
					reservedDate = reserve[i].getReserveDate();
				} 
				if (date.equals(reservedDate)) {
					System.out.print(date + ":" + checkIn + "  ");
					j++;
					
				} else {
					System.out.print(date + ":" + bookUnable + "  ");
				}
			} 
			if ((j + 1) % 5 == 0) {
				System.out.println();
			}
		}
    }

    public static void reserveInputDate(LocalDate date) {
        System.out.println(date);
		for (int i = 0; i < reserve.length; i++) {
			if (date.equals(reserve[i].getReserveDate())) {
				System.out.println(reserve[i].toString());
			}
		}
		System.out.println("(○:예약가능  X:예약완료)");
		int roomNum = 0;
		for (int r = 0; r < reserve.length; r++) {
			if (date.equals(reserve[r].getReserveDate())) {
				roomNum = reserve[r].getReserveRoomNum();
			} 
		}
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if (room[i][j].getRoomNum() == roomNum) {
					System.out.print(room[i][j].getRoomNum() + ":" + checkIn + "  ");
				} else {
					System.out.print(room[i][j].getRoomNum() + ":" + bookAvailable + "  ");
				}
			}
			System.out.println();
		}
    }

    public static boolean reserveCheck(LocalDate date, int roomNum) {
        for (int i = 0; i < reserve.length; i++) {
			if (reserve[i].getReserveDate().isEqual(date) && reserve[i].getReserveRoomNum() == roomNum) {
				System.out.println("이미 예약된 방입니다.");
				System.out.println("다시 예약해주세요.");
				return false;
			} 
		}
		return true;
    }

    public static boolean dateCheck(int input) {
        int year = 2000 + (input / 10000);
		int month = input % 10000 / 100;
		int day = input % 100;
		if ((today.getYear() <= year && year <= today.getYear() + 1) 
				&& (1 <= month && month <= 12)) {
			LocalDate date = LocalDate.of(year, month, 1);
			int lengthOfMonth = date.lengthOfMonth();
			if (1 <= day && day <= lengthOfMonth) {
				date = LocalDate.of(year, month, day);
				if (!today.isAfter(date)) {
					return true;
				}
			}
		}
		return false;
    }

    public static void reservation(Reserve newReserve, Reserve[] origin) {
        reserve = Arrays.copyOf(origin, origin.length + 1);
        reserve[origin.length] = newReserve;
        System.out.println("예약완료");
        int reserveRoomNum = newReserve.getReserveRoomNum();
        int indexFloor = reserveRoomNum / 100 - 2;
        int indexNum = reserveRoomNum % 100 - 1;
        String name = reserve[origin.length].getGuestName();
        String phone = reserve[origin.length].getGuestPhone();
        if (newReserve.getReserveDate().equals(today)) {
			room[indexFloor][indexNum].setGuest(new Guest(name, phone));
			room[indexFloor][indexNum].setRoomStatus("예약중");
		}
		System.out.println(reserve[origin.length].toString());
	}
}


