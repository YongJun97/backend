package a1126.sec06.package1;

public class B {
    public static void main(String[] args) {
        A a = new A();      
        a.field = "value";
        a.method();
    }
    // A와 같은 패키지 안에 있기 때문에 접근이 가능
}
