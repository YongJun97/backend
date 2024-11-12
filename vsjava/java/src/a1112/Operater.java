package a1112;

public class Operater {
    public static void main(String[] args) {
        byte a = 10;
        byte b = 10;
        int result = a + b;
        // 연산 할때는 큰 연산자로 바꿔줘야 하는데 왠만하면 byte는 쓰지말자
        System.out.println("result:"+result);
        byte result1 = 10+20;
        System.out.println("re:"+result1);

        char v6 ='A';
        char v7 = 1;
        int result4 =v6+v7;
        System.out.println("result4: "+ result4);
        System.out.println("result4: "+ (char)result4);
        //66을 아스키 코드로 바꾸면 B

        int v8 = 10;
        int result5 = v8 / 4;
        System.out.println("result5: "+ result5);

        int v9 = 10;
        double result6 = v9 /4.0;
        System.out.println("result6: "+ result6);
        int v10 = 1;
        int v11 = 2;
        double result7 = v10/v11;
        System.out.println("result7: "+ result7);



    }
}
