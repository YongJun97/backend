package printer;

public class Printer {
    public static final String BLANK_HALF = "                          ";
    public static final String BLANK = "                                                    ";
    public static final String CLEAR = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    public static final String ADMIN_PREFIX = "admin_";

    // App.java (메인 페이지) 프린터 시작
    public static final String LIST_HOME1 =                      "                            1 회원 가입";
    public static final String LIST_HOME2 =                      "                            2 로그인";
    public static final String LIST_HOME0 =                      "                            0 프로그램 종료";

    public static final String ADMIN_LIST1 =                     "                            1 사용자 비밀번호 수정";
    public static final String ADMIN_LIST2 =                     "                            2 전체 주문 조회";
    public static final String ADMIN_LIST3 =                     "                            3 사용자 ID로 주문 찾기";
    public static final String ADMIN_LIST4 =                     "                            4 주문 ID로 주문 조회";
    public static final String ADMIN_LIST5 =                     "                            5 주문 삭제";
    public static final String ADMIN_LIST6 =                     "                            6 전체 상품 조회";
    public static final String ADMIN_LIST7 =                     "                            7 상품 ID로 상품 조회";
    public static final String ADMIN_LIST8 =                     "                            8 상품 추가";
    public static final String ADMIN_LIST9 =                     "                            9 상품 제거";
    public static final String ADMIN_LIST0 =                     "                            0 로그아웃";

    public static final String USER_LIST1 =                      "                            1 전체 주문 조회";
    public static final String USER_LIST2 =                      "                            2 주문 조회";
    public static final String USER_LIST3 =                      "                            3 새 주문 생성";
    public static final String USER_LIST4 =                      "                            4 주문에서 상품 추가";
    public static final String USER_LIST5 =                      "                            5 주문에서 상품 제거";
    public static final String USER_LIST6 =                      "                            6 상품 리스트";
    public static final String USER_LIST7 =                      "                            7 상품 조회";
    public static final String USER_LIST0 =                      "                            0 로그아웃";

    public static final String EXCEPTION_DOUBLE_ID = "아이디 중복";
    public static final String EXCEPTION_NO_ID = "아이디 없음";
    public static final String EXCEPTION_WRONG_PW = "비밀번호 불일치";

    public static final String HEADER_HOME =                     "                    \uD83D\uDCB0 쇼핑몰에 오신걸 환영합니다 \uD83D\uDCB0";
    public static final String HEADER_LOGIN =                    "                            \uD83D\uDCB0 로그인 페이지 \uD83D\uDCB0";
    public static final String HEADER_SIGN_UP =                  "                           \uD83D\uDCB0 회원가입 페이지 \uD83D\uDCB0";

    public static final String MESSAGE_WRONG_INPUT =             "                           \uD83D\uDD34 잘못된 입력입니다 \uD83D\uDD34";
    public static final String MESSAGE_DOUBLE_ID =               "                        \uD83D\uDD34 이미 가입된 아이디입니다 \uD83D\uDD34";
    public static final String MESSAGE_NO_ID =                   "                        \uD83D\uDD34 존재하지 않는 아이디입니다 \uD83D\uDD34";
    public static final String MESSAGE_WRONG_PW =                "                       \uD83D\uDD34 비밀번호가 일치하지 않습니다 \uD83D\uDD34";
    public static final String MESSAGE_SUCCESS_SIGNUP =          "                      \uD83D\uDFE2 정상적으로 회원가입 되었습니다 \uD83D\uDFE2";
    public static final String MESSAGE_SUCCESS_LOGOUT =          "                      \uD83D\uDFE2 정상적으로 로그아웃 되었습니다 \uD83D\uDFE2";

    public static final String HEADER_USER =                     "                         \uD83D\uDCB0 회원 페이지 \uD83D\uDCB0";

    public static final String MESSAGE_SUCCESS_LOGIC =           "                     \uD83D\uDFE2 요청이 정상적으로 처리되었습니다 \uD83D\uDFE2";
    public static final String MESSAGE_NO_ACCOUNT =              "             \uD83D\uDD34 잘못 입력하셨거나, 해당 유저의 계좌가 존재하지 않습니다 \uD83D\uDD34";

    public static final String MESSAGE_NO_ORDER =              "             \uD83D\uDD34 잘못 입력하셨거나, 해당 유저의 주문이 존재하지 않습니다 \uD83D\uDD34";
    public static final String MESSAGE_NO_PRODUCT =              "             \uD83D\uDD34 잘못 입력하셨거나, 해당 상품이 존재하지 않습니다 \uD83D\uDD34";
    
    public static final String HEADER_ADMIN =                    "                        \uD83D\uDCB0 관리자 페이지 \uD83D\uDCB0";
    public static final String HEADER_CHANGE_PASSWORD =          "                       \uD83D\uDCB0 사용자 비밀번호 변경 페이지 \uD83D\uDCB0";
    public static final String FOOTER =                          "==============================================================================";

    public static final String HEADER_USER_WELCOME =             " 님 환영합니다!";

    public static final String USER_ID = "\uD83D\uDCB5 사용자 아이디 : ";
    public static final String USER_NAME = "\uD83D\uDCB5 사용자 이름 : ";

    public static final String ALL_USER_ID = "\uD83C\uDFE6 은행 내 모든 사용자 ID 입니다";

    public static final String ENTER_NAME = "☑️ 이름 입력: ";
    public static final String ENTER_ID = "☑️ 아이디 입력: ";
    public static final String ENTER_PW = "☑️ 비밀번호 입력: ";
    public static final String ENTER_TASK_NUM = "☑️ 원하시는 작업을 입력해주세요: ";

    public static final String ENTER_USER_ID = "☑️ 변경하려는 유저 ID를 입력해주세요: ";
    public static final String ENTER_NEW_PW = "☑️ 새로운 비밀번호를 입력해주세요: ";
    public static final String ENTER_USER_ID_ACCOUNT = "☑️ 찾으려는 계좌를 가진 사용자의 ID를 입력해주세요: ";
    public static final String ENTER_ACCOUNT_USER_ACCOUNTNUM = "☑️ 찾으려는 계좌의 계좌번호를 입력해주세요: ";

    public static final String ADMIN_WELCOME_SUFFIX = " 관리자님 환영합니다";

    public static void clearCmd() {
        System.out.println(CLEAR);
    }

    public static void println(String s){
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }
}
