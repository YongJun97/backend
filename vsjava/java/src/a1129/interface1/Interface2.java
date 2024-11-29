package a1129.interface1;

interface Flyable{
    void fly(); // 자바 8 이후 일반 메서드 정의 가능
    
    // void sleep(){ 불가
    //     System.out.println();
    // }

    // default void sleep(){  자바 8 이후 default 메서드는 가능 , 오버라이드도 가능
    //     System.out.println();
    // }

    // static void sleep(){
    //     System.out.println();
    // }  오버라이드 상속 안됨
       // 객체를 만들지 않고 Flyable.sleep() 와 같이 직접호출이 가능
}


interface Swimmable {
    void swim();
}
class Bird implements Flyable{

    @Override
    public void fly() {
        System.out.println("새가 하늘을 난다.");
    }

}
class Fish implements Swimmable{

    @Override
    public void swim() {
        System.out.println("물고기가 수영한다.");
    }

}

// 인터페이스 다중상속이 가능하다.
class Duck implements Flyable, Swimmable{

    @Override
    public void fly() {
        System.out.println("오리가 하늘을 난다.");
        
    }

    @Override
    public void swim() {
        System.out.println("오리가 물속에서 수영한다.");
    }

}
public class Interface2{
    public static void main(String[] args) {
        Bird bird = new Bird();
        Swimmable fish = new Fish();
        Duck duck = new Duck();
        
        bird.fly();
        fish.swim();
        duck.fly();
        duck.swim();
        
    }
}