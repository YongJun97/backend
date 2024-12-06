package project;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class HotelManager {
	private static LocalDate today = LocalDate.now();
	private static Reserve[] reserve;
	private static Room[][] room = new Room[4][10];
	private static String booking1 = "○ ";
	private static String booking2 = "X ";
	private static String booking3 = "● ";
	
	// 룸 초기화
	public static void roomSet() {
		// 룸 객체 생성(생성자 파라미터: 룸번호)
		// 룸 번호 설정 Room[0][1] = 201 -> (0+2)x100+(1+1)=201
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				int roomNo = (i + 2) * 100 + (j + 1);
					room[i][j] = new Room(roomNo);
			}
		}
	}
	
	// 현재 객실 보기
	public static void showRoomStatus() {
		System.out.println("오늘날짜: " + today);
		System.out.println("(○:빈방  ●:예약중  X:체크인)");
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				String todayStatus = room[i][j].getRoomStatus();
				if (todayStatus.equals("체크인")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호:" + booking2 + "  ");
				} else if (todayStatus.equals("예약중")) {
					System.out.print((i + 2) * 100 + (j + 1) + "호:" + booking3 + "  ");
				} else {
					System.out.print((i + 2) * 100 + (j + 1) + "호:" + booking1 + "  ");
				}
			} System.out.println();
		}
	}
	
	// 예약하기
	public static void reservation(Reserve newReserve, Reserve[] origin) {
		reserve = Arrays.copyOf(origin, origin.length + 1);
		reserve[origin.length] = newReserve;
		System.out.println("[예약완료]");
		int reserveRoomNo = newReserve.getReserveRoomNo();
		int indexFloor = reserveRoomNo / 100 - 2; 
		int indexNum = reserveRoomNo % 100 - 1;
		String guestName = reserve[origin.length].getGuestName();
		String guestPhone = reserve[origin.length].getGuestPhone();
		if (newReserve.getReserveDate().equals(today)) {
			room[indexFloor][indexNum].setGuest(new Guest(guestName, guestPhone));
			room[indexFloor][indexNum].setRoomStatus("예약중");
		}
		System.out.println(reserve[origin.length].toString());
	}
	
	// 예약 중복 확인
	public static boolean reserveCheck(LocalDate date, int roomNo) {
		for (int i = 0; i < reserve.length; i++) {
			if (reserve[i].getReserveDate().isEqual(date) && reserve[i].getReserveRoomNo() == roomNo) {
				System.out.println("이미 예약된 방입니다.");
				System.out.println("다시 예약해주세요.");
				return false;
			} 
		}
		return true;
	}
	
	// 날짜 범위 확인
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
	
	// 예약 내역 보기(날짜선택)
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
			if (date.equals(reserve[r].getReserveDate())) { // 입력날짜와 같은 예약이 존재할때 그 예약의 방번호 구하기
				roomNum = reserve[r].getReserveRoomNo();
			} 
		}
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if (room[i][j].getRoomNo() == roomNum) {
					System.out.print(room[i][j].getRoomNo() + ":" + booking2 + "  ");
				} else {
					System.out.print(room[i][j].getRoomNo() + ":" + booking1 + "  ");
				}
			}
			System.out.println();
		}
	}
	
	
	// 예약 내역 보기(방선택)
	public static void reserveInputRoom(int num) {
		for (int i = 0; i < reserve.length; i++) {
			if (reserve[i].getReserveRoomNo() == num) {
				System.out.println(reserve[i].toString());
			} 
		}
		System.out.println("(○:예약가능  X:예약완료)");
		
		for (int j = 0; j < 30; j++) {
			LocalDate date = today.plusDays(j);
			LocalDate reservedDate = LocalDate.of(2022, 1, 1);

			if (reserve.length == 0) {
				System.out.print(date + ":" + booking1 + "  ");
			}
			
			for (int i = 0; i < reserve.length; i++) {
				if (reserve[i].getReserveRoomNo() == num) {
					reservedDate = reserve[i].getReserveDate();
				} 
				if (date.equals(reservedDate)) {
					System.out.print(date + ":" + booking2 + "  ");
					j++;
					
				} else {
					System.out.print(date + ":" + booking1 + "  ");
				}
			} // 논리오류
			if ((j + 1) % 5 == 0) {
				System.out.println();
			}
		}
	}

	
	// 체크인(현재 방 상태 변경: 예약중, 빈방 -> 체크인)(이름입력)
	public static void checkInName(String name) {
		for (int i = 0; i < reserve.length; i++) {
			if (reserve[i].getGuestName().equals(name)) {
				int roomNum = reserve[i].getReserveRoomNo();
				int indexFloor = roomNum / 100 - 2; 
				int indexNum = roomNum % 100 - 1;
				room[indexFloor][indexNum].setRoomStatus("체크인");
				System.out.println("체크인 완료");
			} else {
				System.out.println("예약내역이 없습니다.");
			}
		}
	}
	
	// 체크인(룸넘버)
	public static void checkInRoom(int roomNum) {
		int indexFloor = roomNum / 100 - 2; 
		int indexNum = roomNum % 100 - 1;
		
		room[indexFloor][indexNum].setRoomStatus("체크인");
		System.out.println(room[indexFloor][indexNum].toString());
		System.out.println("체크인 완료");
	}

	// 체크아웃(현재 방 상태 변경: 체크인 -> 체크아웃)
	public static void checkOut(int roomNum) {
		int indexFloor = roomNum / 100 - 2; 
		int indexNum = roomNum % 100 - 1;
		room[indexFloor][indexNum].setRoomStatus("빈방");
		room[indexFloor][indexNum].setGuest(new Guest("", ""));
		System.out.println(room[indexFloor][indexNum].toString());
		System.out.println("체크아웃 완료");
	}
	
	// 객실 정보 보기
	public static void showRoomInformation() {
		for (int i = 0; i < room.length; i++) {
			System.out.println((i + 2) + "층");
			for (int j = 0; j < room[i].length; j++) {
				System.out.println(room[i][j].toString());
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 예약 배열 생성
		reserve = new Reserve[0];
		// 룸 초기화
		roomSet();
	
		boolean go = true;
		while (go) {
			System.out.println("=============");
			System.out.printf("1.현재 객실 보기 \n2.예약하기\n3.예약 내역 보기\n4.체크인\n5.체크아웃\n6.객실 정보 보기\n0.프로그램 종료\n");
			System.out.println("=============");
			System.out.print("번호 입력: ");
			int user = scan.nextInt();
			System.out.println("=============");
			switch (user) {
			case 1:
				System.out.println("[현재 객실 보기]");
				showRoomStatus();
				break;
			case 2: 
				System.out.println("[예약하기]");
				// 날짜입력
				System.out.print("*날짜입력(6자리숫자): ");
				LocalDate inputDate = today;
				boolean dateGo = true;
				while (dateGo) { // 범위벗어날때 확인하기
					int date = scan.nextInt();
					if (dateCheck(date)) {
						int year = 2000 + (date / 10000);
						int month = date % 10000 / 100;
						int day = date % 100;
						inputDate = LocalDate.of(year, month, day);
						dateGo = false;
					} else {
						System.out.print("*다시입력해주세요(6자리숫자): ");
					}
				}
				// 방선택
				System.out.println("*방선택(홀수:싱글룸/짝수:더블룸)");
				System.out.print("-방번호 입력(201~510): ");
				int inputRoomNo = 0;
				boolean roomGo = true;
				while(roomGo) {
					inputRoomNo = scan.nextInt();
					int roomFloor = inputRoomNo / 100; 
					int roomNum = inputRoomNo % 100;
					if (2 <= roomFloor && roomFloor <= 5 && 0 < roomNum && roomNum <= 10) {
						roomGo = false;
					} else {
						System.out.print("다시입력해주세요(201~520): ");
					}
				}
				// 중복확인
				if (reserveCheck(inputDate, inputRoomNo)) {
					// 예약자 정보
					System.out.println("*예약자 정보 입력");
					System.out.print("-이름: ");
					String inputName = scan.next();
					System.out.print("-폰번호: ");
					String inputPhone = scan.next();
					// 예약
					reservation(new Reserve(inputDate, inputRoomNo, inputName, inputPhone), reserve);
				}
				break;
			case 3: 
				System.out.println("[예약 내역 보기]");
				System.out.println("1.날짜선택  2.방선택");
				System.out.print("번호 입력: ");
				int input = scan.nextInt();
				if (input == 1) {
					System.out.print("*날짜입력(6자리숫자): ");
					int date = scan.nextInt();
					if (dateCheck(date)) {
						int year = 2000 + (date / 10000);
						int month = date % 10000 / 100;
						int day = date % 100;
						inputDate = LocalDate.of(year, month, day);
						reserveInputDate(inputDate);
					} else {
						System.out.println("잘못된 입력입니다.");
					}
				} else if (input == 2) {
					System.out.print("*방번호 입력(201~520): ");
					int input2 = scan.nextInt();
					reserveInputRoom(input2);
				} else {
					System.out.println("잘못된 입력입니다.");
				}
				break;
			case 4: 
				System.out.println("[체크인]");
				System.out.println("1.예약자이름입력하기  2.방번호입력하기");
				System.out.print("번호 입력: ");
				int checkIn = scan.nextInt();
				if (checkIn == 1) {
					System.out.print("이름 입력: ");
					checkInName(scan.next());
				} else if (checkIn == 2) {
					System.out.print("방번호 입력(201~520): ");
					checkInRoom(scan.nextInt());
				} else {
					System.out.println("잘못된 입력입니다.");
				}
				break;
			case 5: 
				System.out.println("[체크아웃]");
				System.out.print("방번호 입력(201~520): ");
				checkOut(scan.nextInt());
				break;
			case 6: 
				System.out.println("[객실 정보 보기]");
				showRoomInformation();
				break;
			default:
				System.out.println("[프로그램 종료]");
				go = false;
				break;
			}
		}
	}
}
