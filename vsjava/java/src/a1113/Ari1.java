package a1113;

public class Ari1 {
        public static void main(String[] args) {
            byte v1 = 10;
            byte v2 = 4;
            int V3 = 5;
            long v4 = 4L;

            int result1 = v1 + v2;
            System.out.println("result1:" + result1); // 모든 연산자는 int 타입으로 자동변환 후 연산 = 14;

            long result2 = v1 + v2 - v4;
            System.out.println("result2:" + result2); // 모든 피연산자는 long 타입으ㅡ로 자동 변환 후 연산

            double result3 = (double) v1 / v2;
            System.out.println("result3:" + result3); //byte 와 byte가 만나면 int(정수형계산)로 변환되기 때문에 double 타입으로 강제 변환 후 연산

            int result4 = v1 % v2; //나눈 후의 나머지
            System.out.println("result4:" + result4);





        }
}
