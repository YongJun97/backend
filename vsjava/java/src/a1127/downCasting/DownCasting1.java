package a1127.downCasting;

class Animal{
    public void move(){
        System.out.println("움직입니다.");
    }
}
class Bird extends Animal{
    
    public void bark(){
        System.out.println("짹짹");
    }

    @Override
    public void move() {
        System.out.println("날아갑니다.");
    }
}




public class DownCasting1 {
    public static void main(String[] args) {
        // Animal animal = new Animal();
        // Bird bird = new Bird();
        // animal.move();
        // bird.bark();
        // bird.move();
        Animal animal = new Bird(); // 업캐스팅(자동)
        animal.move();
        // animal.bark(); 불가

        // 다운캐스팅
        // if(animal instanceof Bird){
        //     Bird bird = (Bird) animal;
        //     bird.bark();
        // }else{
        //     System.out.println("Bird 타입이 아닙니다.");
        // }

        // 자바 17버전 이상
        if(animal instanceof Bird bird){
            // Bird bird = (Bird) animal;
            bird.bark();
        }else{
            System.out.println("Bird 타입이 아닙니다.");
        }

    }
}
