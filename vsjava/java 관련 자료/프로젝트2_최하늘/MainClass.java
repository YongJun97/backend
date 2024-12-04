package out;

import java.util.InputMismatchException;

public class MainClass {
    public static void main(String[] args) throws AppException {
        ExcuteApp excute = new ExcuteApp();

        int selectNo = 0;
        boolean run = true;

        while (run) {
            excute.printMenu(); // 메뉴 프린트
            try {
                selectNo = excute.selectNum(); // 번호 선택
                run = excute.selectMenu(selectNo, excute); // 선택한 번호로 메뉴 실행.
            } catch (InputMismatchException e) {
                System.out.println("잘못된 메뉴 선택입니다.");
            }
        }
    }
}
