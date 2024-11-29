package a1129.interface1;

interface Animal {
    // void abc(){
    //     System.out.println("안녕");
    // } 일반메소드 불가

    public abstract void cry();
    // 추상 메소드만 사용
}
class Cat implements Animal{

    @Override
    public void cry() {
        System.out.println("냐옹!");
        
    }

}
class Dog implements Animal{

    @Override
    public void cry() {
        System.out.println("멍멍!");
        
    }

}


public class Interface1 {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();

        c.cry();
        d.cry();

        Animal e = new Cat();
        Animal g = new Dog();
        
        e.cry();
        g.cry();
    }
}
