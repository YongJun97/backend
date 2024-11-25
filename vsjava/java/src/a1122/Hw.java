package a1122;

import java.util.Arrays;

public class Hw {
    public static void main(String[] args) {
        Student s = new Student("홍길동",20231234,90,85,92);
        
        
        System.out.println("이름: "+ s.getName());
        System.out.println("학번: "+ s.getNumber());
        System.out.println("점수: " + Arrays.toString(s.getScore()));
                        // Arrays.toString 매서드를 사용하면 배열주소에 있는 데이터를 육안으로 볼 수 있는 데이터로 변환이 가능하다

        int[] scores = s.getScore();
        String[] sub = {"국어","수학","영어"};
        String[] la = new String[scores.length];

        scores[0] = 85;

        // System.out.println("점수수정: " + Arrays.toString(s.getScore()));

        for(int i =0; i < scores.length; i++){
            la[i] = sub[i] + ":" + scores[i];
        }
        
        System.out.println("점수: " + Arrays.toString(la));
        
        // 평균
        double avg = avg(scores);
        System.out.println("평균: "+ avg);
        //int sum = plus(scores); // 합계 계산 메서드 호출
        //System.out.println("합계: " + sum); 

    }
        public static int plus(int[] scores){
                int sum = 0;
                for(int score : scores){
                    sum += score;
                }
                return sum;
            }
        public static double avg(int[] scores){
            int sum = plus(scores);
            double avg = (double) sum / scores.length;
            return avg;
        }




    static class Student {
        private String name;
        private int number;
        private int[] score;

        public Student(String name, int number, int... score) {
            this.name = name;
            this.number = number;
            this.score = score;
        }
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getNumber() {
            return number;
        }
        public void setNumber(int number) {
            this.number = number;
        }
        public int[] getScore() {
            return score;
        }
        public void setScore(int[] score) {
            this.score = score;
        }
    }
}
