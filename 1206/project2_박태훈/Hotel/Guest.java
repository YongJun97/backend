package project2.Hotel;

public class Guest {
    private String name;
	private String phoneNum;
	public Guest(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNum;
	}
	public void setPhoneNumber(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "[이름: " + name + ", 폰번호: " + phoneNum + "]";
	}
}
