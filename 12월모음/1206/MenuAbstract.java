package Project2_이슬;

import java.util.Scanner;

abstract class MenuAbstract implements Menu{ // interface를 abstract에서 implement, 각 메뉴는 abstract를 상속

    // 멤버 변수
    // 각 메뉴의 기본 문구가 저장될 변수
    // 선택완료 후 현재의 메뉴가 저장될 이전 메뉴 변수
    // 스캐너
    
    // 메서드
    // 생성자
    // showmenu()
    // 이전 메뉴 세터

    protected String menuText;
    protected Menu prevMenu;
    protected static final Scanner scan = new Scanner(System.in);

    public MenuAbstract(String menuText, Menu prevMenu) {
        this.menuText = menuText;
        this.prevMenu = prevMenu;
    }
    
    public void showMenu(){
        System.out.print("\n" + menuText);
    }

    public void setPrevMenu(Menu prevMenu) {
        this.prevMenu = prevMenu;
    }
}
