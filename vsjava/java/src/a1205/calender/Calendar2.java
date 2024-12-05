package a1205.calender;

import java.util.Calendar;

public class Calendar2 {
    public static void main(String[] args) {
        
        Calendar calendar = Calendar.getInstance();

        Calendar startDate = Calendar.getInstance();
        startDate.set(2025,Calendar.JANUARY,1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2025,Calendar.DECEMBER,31);
        long startMillis = startDate.getTimeInMillis();
        long endMillis = endDate.getTimeInMillis();
        long diff = endMillis - startMillis;
        long diffDays = diff / (24*60*60*1000);
        System.out.println("두 날짜의 차이는 " + diffDays + "일입니다.");


    }
}
