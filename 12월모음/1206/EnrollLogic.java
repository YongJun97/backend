package Project2_이슬;

import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class EnrollLogic {
    
    static String uID = new String();
    static HashMap<String, Enrollment> enrollMap = new HashMap<>();
    static HashMap<String, Programs> prgmMap = new HashMap<>();
    static DataFile enrollFile = new DataFile("enrollment");
    static DataFile prgmFile = new DataFile("programs");
    static Scanner scan = new Scanner(System.in);
    static Enrollment enroll = null;

    public static void enrollPrgm(String i) throws Exception {
        uID = i;
        enrollMap = enrollFile.enrollLoadFile();
        prgmMap = prgmFile.prgmLoadFile();

        System.out.println("\n\n-><--><-->< 말꽃 프로그램 신청 ><--><--><-\n\n");

        ProgramManager.showAllPrograms();
        System.out.print("\n\n신청할 수업 선택 (번호 입력): ");
        String pID = scan.next();
        String title = prgmMap.get(pID).getTitle();
        System.out.printf("\n[%s]수업을 신청하시겠습니까? (Y/N)", title);
        String str = scan.next();
        if (str.equalsIgnoreCase("Y")){
            enrollFile.createfile();
            enrollMap = enrollFile.enrollLoadFile();
            String eID = creatEID();
            enroll = new Enrollment(eID, uID, pID);
            enrollMap.put(eID, enroll);
            savedata();
            System.out.println("수업이 신청되었습니다.");
        } else if (str.equalsIgnoreCase("N")) {
            System.out.println("수업 신청이 취소되었습니다.");
        } else {
            System.out.println("다시 입력해 주세요.");
        }
    }
    
    private static String creatEID() {
        return Long.toString(Instant.now().toEpochMilli());
    }

    private static void savedata() {
        String[] enrollArr = new String[enrollMap.size()];
        Iterator<String> keyList = enrollMap.keySet().iterator();
        int r=0;
        while(keyList.hasNext()){
            String key = keyList.next();
            Enrollment enroll = enrollMap.get(key);
            enrollArr[r] = enroll.toString();
            r++;
        }
        enrollFile.saveFile(enrollArr);
    }

    public static void myPrograms(String id) throws Exception {
        uID = id;                                   // 내 id 저장
        enrollMap = enrollFile.enrollLoadFile();    // 수강신청 전체 map 저장
        String pID = new String();
        prgmMap = prgmFile.prgmLoadFile();          // 프로그램 전체 map 저장
        Iterator<String> keys = enrollMap.keySet().iterator();

        System.out.println("\n\n내가 신청한 수업:");
        while (keys.hasNext()) {
            String key = keys.next();
            Enrollment temp = enrollMap.get(key);
            if (temp.getuID().equals(uID)) {
                pID = temp.getpID();
                System.out.println("["+key+"]" + prgmMap.get(pID));
            }
        }
    }

    public static void cancle(String id) throws Exception {
        uID = id;
        enrollMap = enrollFile.enrollLoadFile();

        System.out.println("\n\n-><--><-->< 말꽃 프로그램 신청 취소 ><--><--><-\n\n");
        myPrograms(uID);

        System.out.print("\n\n취소할 수업 선택 (번호 입력): ");
        String eID = scan.next();
        System.out.print("\n수업 신청을 취소하시겠습니까? (Y/N)");
        String str = scan.next();
        if (str.equalsIgnoreCase("Y")){
            enrollMap.remove(eID);
            savedata();
            System.out.println("수업 신청이 취소되었습니다.");
        } else if (str.equalsIgnoreCase("N")) {
            System.out.println("수업 신청이 취소되지 않았습니다. 취소를 원하시면 다시 시도해 주세요.");
        } else {
            System.out.println("다시 입력해 주세요.");
        } 
    }
}