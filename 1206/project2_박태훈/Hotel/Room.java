package project2.Hotel;

public class Room {
    private int roomNum;
    private String roomType;
    private String roomStatus;
    private Guest guest;

    public Room(int roomNum){
        this.roomNum = roomNum;
        if(roomNum % 2 == 0){
            roomType = "Double";
        } else{
            roomType = "Single";
        }
        roomStatus = "빈방";
        guest = new Guest("", "");
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
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
        return "[객실 번호: " + roomNum + ", 객실 타입: " + roomType + ", 현재 객실 상태: " + roomStatus + ", 고객 정보: " + guest + "]";
    }

    
    
}
