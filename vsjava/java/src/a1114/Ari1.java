package a1114;

public class Ari1 {
        public static void main(String[] args) {
            //4번
            int value = 356;
            System.out.println();
            System.out.println(value/100 * 100);
            System.out.println("-------------------");

            //5번
            int lengt = 5;
            int lengb = 10;
            int height = 7;
            // double area = (lengt+lengb)*height/2.0; = 52.5
            // double area = (lengt+lengb)*height*1.0 /2; = 52.5
            double area = (double)(lengt+lengb)*height/2;  // = 52.5
            // double area = ((double)(lengt+lengb)*height/2;) = 괄호를 전체로 덮는건 안됨
            System.out.println(area);

            System.out.println("-------------------");
            // 6번
            int x = 10;
            int y = 5;

            System.out.println( (x>7) && (y<=5) );
            System.out.println((x%3 == 2) || (y%2 !=1));
            System.out.println("-------------------");
            // 7번
            double x1 = 5.0;
            double y1 = 0.0;
            double z = 5 % y1;
            if(Double.isInfinite(z) || Double.isNaN(z)){
                System.out.println("값산출불가");
            }else{
                double result3 = z+10;
                System.out.println(result3);
            }

        }
}
