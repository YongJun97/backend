package Project2_이슬;

public class ProgramMenu extends MenuAbstract {
    
// 멤버 변수
// menuText

// 메서드
// 생성자 (상위 클래스의 생성자 상속)
// interface에서 선언한 next()

    static String id = MemberLogic.userId;
    private static final ProgramMenu instance = new ProgramMenu(null);
    private static final String menuText =
        "\n\n"+
        "1 : 전체 수업 보기\n" +     
        "2 : 수강 신청\n" +   
        "3 : 내가 신청한 수업 보기\n" +   
        "4 : 수강 신청 취소\n" +      
        "L : 로그인\n" +   
        "J : 회원가입\n" +   
        "Q : 종료\n\n" +
        "메뉴를 선택하세요 >>>"; 

    ProgramMenu (Menu prevMenu) {
        super (menuText, prevMenu);
    }

    public static ProgramMenu getInstance(){
        return instance;
    }

    @Override
    public Menu next() throws Exception{
        String choice = scan.next();
        switch (choice) {
            case "1":
                ProgramManager.showAllPrograms();
                return this;
            case "2":
                if (id != null ){
                    EnrollLogic.enrollPrgm(id);
                } else {
                    System.out.println("로그인 후 신청 가능합니다.");
                }
                return this;
            case "3":
                if (id != null ){
                    EnrollLogic.myPrograms(id);
                } else {
                    System.out.println("로그인 후 조회 가능합니다.");
                }
                return this;
            case "4":
                if (id != null ){
                    EnrollLogic.cancle(id);
                } else {
                    System.out.println("로그인 후 취소 가능합니다.");
                }
                return this;
            case "L":
            case "l":
            case "ㅣ":
                id = MemberLogic.login();
                return this;
            case "J":
            case "j":
            case "ㅓ":
                MemberLogic.signUp();
                return this;
            case "Q":
            case "q":
            case "ㅂ":
                return prevMenu;
            default:
                System.out.println("잘못 선택하셨습니다. 다시 선택해 주세요.");
                return this;
        }   
    }
}
