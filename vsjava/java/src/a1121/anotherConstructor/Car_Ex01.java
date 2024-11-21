package a1121.anotherConstructor;

public class Car_Ex01 {
    public static void main(String[] args) {
        

        Car car2 = new Car("자가용");
        System.out.println("car2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);
        System.out.println();

        Car car3 = new Car("자가용", "빨강");
        System.out.println("car3.company : " + car3.company);
        System.out.println("car3.moedel : " + car3.model);
        System.out.println("car3.color : " + car3.color);
        System.out.println();

        Car car4 = new Car("택시","검정",200);
        System.out.println("car4 : " + car4.company);
        System.out.println("car4 : " + car4.model);
        System.out.println("car4 : " + car4.color);
        System.out.println("car4 : " + car4.maxSpeed);
    }
}