package a1111;

public class Var3 {
    public static void main(String[] args) {
        int x = 5;
        int y = 3;
        
        System.out.println("x:" + x + ", y:" + y);
        int temp = x;
        x = y; // x의값이 무시되고 y갑인 5가 대입
        y = temp; //y에 temp에 있던 3의 대입
        
        System.out.println("x:" + x + ", y:" + y);
    }
}
