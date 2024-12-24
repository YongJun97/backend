package Project2_이슬;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MemberLogic {

    public static String userId;

    static Scanner scan = new Scanner(System.in);
    private static HashMap<String, Members> memberMap = new HashMap<String, Members>();
    static DataFile fileCtrl;

    public static void signUp() throws Exception {
        
        fileCtrl = new DataFile("members");
        fileCtrl.createfile();
        memberMap = fileCtrl.memLoadFile();

        System.out.println("\n\n-><--><-->< 말꽃 회원가입 ><--><--><-");
        System.out.println("(** 항목은 필수 입력 항목입니다.)");

        System.out.print("** ID : ");
        String id = scan.next();
        System.out.print("** 비밀번호 : ");
        String pw = scan.next();

        System.out.print("** 이름 : ");
        String name = scan.next();
        System.out.print("** 태어난 연도 : ");
        int bYear = scan.nextInt();
        System.out.print("** 전화번호 (010-0000-0000): ");
        String phone = scan.next();
        scan.nextLine();
        System.out.print("주소 : ");
        String address = scan.nextLine();
        System.out.print("이메일 : ");
        String email = scan.next();
        
        Members member = null; 
        member = new Members(id, pw, name,bYear,phone ,address,email);
        memberMap.put(id, member);

        savedata();
    }

    private static void savedata() {
        String[] memArr = new String[memberMap.size()];
        Iterator<String> keyList = memberMap.keySet().iterator();
        int r=0;
        while(keyList.hasNext()){
            String key = keyList.next();
            Members member = memberMap.get(key);
            memArr[r] = member.toString();
            r++;
        }
        fileCtrl.saveFile(memArr);
    }

    public static String login() throws Exception {
        fileCtrl = new DataFile("members");
        memberMap = fileCtrl.memLoadFile();
        String inputId;
        userId = null;
        String inputPw;
        String pw = null;
        boolean loggedIn = false;
        
        while (!loggedIn) {
            System.out.println("\n\n-><--><-->< 말꽃 시스템 로그인 ><--><--><-");
            System.out.print("ID를 입력하세요 : ");
            inputId = scan.next();

            if (memberMap.containsKey(inputId)) {
                pw = memberMap.get(inputId).getPw();
                userId = inputId;

                System.out.print("비밀번호를 입력하세요 : ");
                inputPw = scan.next();
                
                if (inputPw.equals(pw)) {
                    System.out.println("로그인에 성공했습니다.");
                    loggedIn = true;
                } else {
                    System.out.println("비밀번호가 틀렸습니다. 다시 시도하세요.");
                }
            } else {
                System.out.println("존재하지 않는 ID 입니다. 다시 시도하세요.");
            }
        }
        return userId;
    }


    
}
