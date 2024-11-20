package a1120;

import java.util.Scanner;

public class Hak_Ex09_1 {
    public static void main(String[] args) {
        boolean run = true;


        int studentNum = 0;
        int[] scores = null;
        Scanner scanner =new Scanner(System.in);
        while (run) {
            System.out.println("---------------------------------------------------------");
            System.out.println("1.학생수  ㅣ 2.점수입력 ㅣ 3.점수리스트 ㅣ 4.분석 ㅣ 5.종료");
            System.out.println("---------------------------------------------------------");

            System.out.println("선택>");
            int selectNo = Integer.parseInt(scanner.nextLine());
            // 줄단위로 문자처럼 입력받고 parseInt 숫자로 변환
            if(selectNo == 1){
                System.out.println("학생수>");
                studentNum = Integer.parseInt(scanner.nextLine());
                scores = new int[studentNum];
            }else if(selectNo == 2){
                for(int i=0; i < scores.length; i++){
                    System.out.print("scores["+i+"]>");
                    scores[i] = Integer.parseInt(scanner.nextLine());
                }
            }else if(selectNo == 3){
                for(int i=0; i < scores.length; i++){
                    System.out.println("scores["+i+"]: " +scores[i]);
                }
            }else if(selectNo==4){
                int max = 0;
                int sum = 0;
                double avg = 0;
                for(int i =0; i<scores.length;i++){
                    max = (max < scores[i])? scores[i] : max;
                    sum = sum + scores[i];
                }
                avg = (double) sum / studentNum;
                System.out.println("최고점수: " + max);
                System.out.println("평균점수: " + avg);
            }else if(selectNo==5){
                run = false;
            }

            
        }
        System.out.println("프로그램종료");



    }
}
