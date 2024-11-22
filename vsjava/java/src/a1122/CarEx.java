package a1122;



class Car{
    String brand;
    String model;

    Car(){
        this("Unknown","Unknown"); // 다른 생성자 호출
    }
    //매개변수 한개
    Car(String brand){
        this(brand,"Unknown");
    }
    //매개변수 두개
    Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    void dis(){
        // 여기는 출력하기 위한 함수이기 때문에 이름은 마음대로 지어도됨
        System.out.println("Brand: " + brand + ",Model: "+ model);
    }


}

public class CarEx {
    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Toyota");
        Car car3 = new Car("Honda","Civic");

        car1.dis();
        car2.dis();
        car3.dis();
    }
}
// this 는 현재 객체 자신을 참조

// this() 는 현재 클래스의 다른 생성자 호출 (위의 this 와는 쓰임이 다름)