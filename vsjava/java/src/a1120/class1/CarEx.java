package a1120.class1;

public class CarEx {
        public static void main(String[] args) {
            // Car 객체 생성
            Car st1 = new Car();
            st1.company = "HUNDAE";
            st1.model = "SONATA DN8";
            st1.color = "BLACK";
            st1.maxSpeed = 260;
            st1.speed = 100;

            System.out.println("회사 : " + st1.company);
            System.out.println("모델 : " + st1.model);
            System.out.println("색상 : " + st1.color);
            System.out.println("최고속도 : " + st1.maxSpeed);
            System.out.println("권장속도 : " + st1.speed);
        }
}
