package a1126.sec03;

public class Phone {
    // 필드선언
    public String model;
    public String color;

    public Phone(String model, String color) {
        this.model = model;
        this.color = color;
    }
    // 메소드 선언
    public void bell(){
        System.out.println("벨이 울립니다.");
    }
    public void sendVoice(String message){
        System.out.println("본인:" + message);
    }
    public void receiveVoice(String message){
        System.out.println("상대방:" + message);
    }

    public void hangUp(){
        System.out.println("전화를 끊습니다.");
    }
}