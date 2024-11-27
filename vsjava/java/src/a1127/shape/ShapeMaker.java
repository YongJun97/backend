package a1127.shape;

import java.util.Scanner;

public class ShapeMaker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape shape = null;
        double width = 0.0;
        double height = 0.0;
        double radius = 0.0;
        // 총합
        double roundSum = 0.0;
        double areaSum = 0.0;

        // 입력 담은 도형 정보 배열
        Shape[] shapeList = new Shape[3];
        int index = 0;

        while (true) {
            if(index == 3) break;
                
            System.out.println("1.삼각형, 2.사각형, 3.원형");
            System.out.print(">>");            
            String input = sc.next();

            if(input.equals("그만")) break;
            // 삼각형
            switch (input) {
                case "1":
                    System.out.println("가로>>");
                    width = sc.nextDouble();
                    System.out.println("높이>>");
                    height = sc.nextDouble();
                    shape = new Triangle(width,height); // 업캐스팅
                    shapeList[index++] = shape;
                    break;
            // 사각형
                case "2":
                    System.out.println("가로>>");
                    width = sc.nextDouble();
                    System.out.println("높이>>");
                    height = sc.nextDouble();
                    shape = new Rectangle(width,height); // 업캐스팅
                    shapeList[index++] = shape;
                    break;
            // 원형
                case "3":
                    System.out.println("반지름>>");
                    radius = sc.nextDouble();
                    shape = new Circle(radius); // 업캐스팅
                    shapeList[index++] = shape;
                    break;    
                default:
                    break;
            }

        }
        
        
            for(Shape s : shapeList){
                if(s == null) continue;

                // instanceof 인스턴스를 비교하는 연산
                if(s instanceof Triangle){
                    System.out.println("[삼각형]");
                }
                if(s instanceof Rectangle){
                    System.out.println("[사각형]");
                }
                if(s instanceof Circle){
                    System.out.println("[원형]");
                }

                double area = s.area();
                double round = s.round();

                roundSum = roundSum + round;
                // areaSum = areaSum + area;
                areaSum += area;

                System.out.println("넓이 : " + area + "\t");
                System.out.println("둘레 : " + round + "\t");
                System.out.println();


            }


    }
}
