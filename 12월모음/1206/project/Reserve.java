package project;

import java.time.LocalDate;

public class Reserve {
	private LocalDate reserveDate;
	private int reserveRoomNo;
	private String guestName;
	private String guestPhone;
	public Reserve(LocalDate reserveDate, int reserveRoomNo, String guestName, String guestPhone) {
		this.reserveDate = reserveDate;
		this.reserveRoomNo = reserveRoomNo;
		this.guestName = guestName;
		this.guestPhone = guestPhone;
	}
	public LocalDate getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}
	public int getReserveRoomNo() {
		return reserveRoomNo;
	}
	public void setReserveRoomNo(int reserveRoomNo) {
		this.reserveRoomNo = reserveRoomNo;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	public String getGuestPhone() {
		return guestPhone;
	}
	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}
	@Override
	public String toString() {
		return "[예약날짜: " + reserveDate + ", 방번호: " + reserveRoomNo + ", 예약자 성함: " 
        		+ guestName + ", 예약자 연락처: " + guestPhone + "]";
	}
}
