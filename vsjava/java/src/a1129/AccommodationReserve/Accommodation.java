package a1129.AccommodationReserve;

// 숙소 클래스
public class Accommodation {
    

    private String name; // 이름
    private String location; // 위치
    private double pricePerNight; // 가격
    private boolean availablel; // 예약가능여부
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isAvailablel() {
        return availablel;
    }

    public void setAvailablel(boolean availablel) {
        this.availablel = availablel;
    }

    public Accommodation(){
        
    }


    public Accommodation(String name, String location, double pricePerNight) {
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
        this.availablel = true;
    }

    public void book(){
        this.availablel = false;
        // book 을 실행 시 false를 this에 넣는다
    }

    @Override
    public String toString() {
        return "숙소이름 = " + name + ", 위치 =" + location + ", 박 당 가격 =" + pricePerNight
                + ", 예약여부 =" + (availablel ? "예약가능" : "예약불가");
    }



}
