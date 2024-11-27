package a1127.upcasting;

public class UpcastingEx {
    public static void main(String[] args) {
        Child childObj = new Child();
        Parent parentObj = new Parent();
        childObj.show(); // 출력 - 자식객체 메서드
        childObj.childspecial();
        parentObj.show(); // 부모객체 메서드
        Parent parentRef = childObj; // 업캐스팅 (묵시적 형변환) 자식이 부모 타입으로
        parentRef.show(); // 출력 - 자식객체 메서드
        // parentRef.childspecial(); 오류: parent 클래스에서 정의되지 않은 매서드는(사용불가)

    }
}
class Parent{
    void show(){
        System.out.println("부모클래스 메서드");
    }
}
class Child extends Parent{

    @Override
    void show() {
        System.out.println("자식클래스 메서드");
    }
    void childspecial(){
        System.out.println("자식의 특별한 매서드");
    }
}