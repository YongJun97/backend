package project;

public class Room {
	private int roomNo;
	private String roomType;
	private String roomStatus;
	private Guest guest;
	
	public Room(int roomNo) {
		this.roomNo = roomNo;
		if(roomNo % 2 == 0) {
			roomType = "double";
		} else {
			roomType = "single";
		}
		roomStatus = "빈방"; // 초기화한 후 예약받을 때 상태 변경
		guest = new Guest("", ""); // 초기화한 후 예약받을 때 게스트 만들기
	}
	
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomStatus() {
		return roomStatus;
	}
	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	@Override
	public String toString() {
		return "[방번호: " + roomNo + ", 방타입: " + roomType + ", 현재 객실 상태: " 
        		+ roomStatus + ", 고객정보" + guest +"]";
	}
}
