package project.football;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        MatchManager mm = new MatchManager();
        System.out.println("경기 예약 시스템입니다.");

        try {
            mm.menu();
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
    }
}