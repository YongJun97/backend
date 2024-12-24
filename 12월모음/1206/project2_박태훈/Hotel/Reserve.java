package project2.Hotel;

import java.time.LocalDate;

public class Reserve {
    private LocalDate reserveDate;
	private int reserveRoomNum;
	private String guestName;
	private String guestPhone;
	public Reserve(LocalDate reserveDate, int reserveRoomNo, String guestName, String guestPhone) {
		this.reserveDate = reserveDate;
		this.reserveRoomNum = reserveRoomNo;
		this.guestName = guestName;
		this.guestPhone = guestPhone;
	}
	public LocalDate getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}
	public int getReserveRoomNum() {
		return reserveRoomNum;
	}
	public void setReserveRoomNo(int reserveRoomNo) {
		this.reserveRoomNum = reserveRoomNo;
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
        return "[예약 날짜: " + reserveDate + ", 예약할 객실 번호: " + reserveRoomNum + "호" + ", 이름: " + guestName + ", 핸드폰 번호: " + guestPhone + "]";
    }

    
}
