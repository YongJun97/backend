package out;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExcuteApp {
    Scanner sc = new Scanner(System.in);
    public static Map<Integer, EmployeeDTO> employees = new HashMap<>();
    private static Map<Integer, EmployeeWorkDTO> ew = new HashMap<>();
    private static FileControl fc = new FileControl();
    
    public static Map<Integer, EmployeeDTO> getEmployees() {
        return employees;
    }
    
    ExcuteApp() {
        EmployeeDTO a = new EmployeeDTO(1, "김필주", "팀장");
        EmployeeDTO b = new EmployeeDTO(2, "공국찬", "선임");
        EmployeeDTO c = new EmployeeDTO(3, "이승수", "선임");
        EmployeeDTO d = new EmployeeDTO(4, "김대훈", "선임");
        EmployeeDTO e = new EmployeeDTO(5, "이희종", "선임");
        EmployeeDTO f = new EmployeeDTO(6, "안준기", "선임");
        EmployeeDTO g = new EmployeeDTO(7, "김종혁", "주임");
        EmployeeDTO h = new EmployeeDTO(8, "서원준", "주임");
        EmployeeDTO i = new EmployeeDTO(9, "노희대", "주임");
        employees.put(1, a);
        employees.put(2, b);
        employees.put(3, c);
        employees.put(4, d);
        employees.put(5, e);
        employees.put(6, f);
        employees.put(7, g);
        employees.put(8, h);
        employees.put(9, i);

        EmployeeWorkDTO aa = new EmployeeWorkDTO(1);
        EmployeeWorkDTO bb = new EmployeeWorkDTO(2);
        EmployeeWorkDTO cc = new EmployeeWorkDTO(3);
        EmployeeWorkDTO dd = new EmployeeWorkDTO(4);
        EmployeeWorkDTO ee = new EmployeeWorkDTO(5);
        EmployeeWorkDTO ff = new EmployeeWorkDTO(6);
        EmployeeWorkDTO gg = new EmployeeWorkDTO(7);
        EmployeeWorkDTO hh = new EmployeeWorkDTO(8);
        EmployeeWorkDTO ii = new EmployeeWorkDTO(9);
        ew.put(1, aa);
        ew.put(2, bb);
        ew.put(3, cc);
        ew.put(4, dd);
        ew.put(5, ee);
        ew.put(6, ff);
        ew.put(7, gg);
        ew.put(8, hh);
        ew.put(9, ii);

    }

    public void insertEmployee() {
        System.out.println("신규 사원 입력");
        System.out.print("이름 > ");
        String name = sc.nextLine();
        System.out.print("직급 > ");
        String grade = sc.nextLine();
        System.out.print("사원 번호 > ");
        int id = Integer.parseInt(sc.nextLine());
        boolean flag = true;
        while (flag) {
            if (employees.containsKey(id)) {
                System.out.println("존재하는 사원 번호 입니다. 다시 입력해주세요.");
                id = Integer.parseInt(sc.nextLine());
            } else {
                flag = false;
            }
        }

        System.out.print("결과 : ");
        employees.put(id, new EmployeeDTO(id, name, grade));
        ew.put(id, new EmployeeWorkDTO(id));
        System.out.println("사원 입력 성공.");

    }

    public void printEmployeeList() {
        for (Integer key : employees.keySet()) {
            System.out.println(employees.get(key));
        }
        System.out.println();
    }

    public void updateEmployeeInformation() {
        System.out.println("사원 정보 수정");
        System.out.print("사원 번호 > ");
        int id = Integer.parseInt(sc.nextLine());
        try {
            EmployeeDTO e = findEmployee(id);
            System.out.println("메뉴를 선택해주세요.\n1. 이름 변경 \t2. 직급 변경\t3. 사원 번호 변경");
            int menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 1:
                    System.out.print("변경할 이름을 입력 > ");
                    String newName = sc.nextLine();
                    e.setName(newName);
                    employees.replace(id, e);
                    System.out.println("변경을 완료하였습니다.");
                    break;
                case 2:
                    System.out.print("변경할 직급 입력 > ");
                    String newGrade = sc.nextLine();
                    e.setGrade(newGrade);
                    employees.replace(id, e);
                    System.out.println("변경을 완료하였습니다.");
                    break;
                case 3:
                    System.out.print("변경할 사원번호 입력 > ");
                    int newId = Integer.parseInt(sc.nextLine());
                    if (employees.containsKey(newId)) {
                        System.out.println("이미 존재하는 사원 번호입니다.");
                        break;
                    } else {
                        e.setId(newId);
                        employees.remove(id);
                        employees.put(newId, e);
                        ew.remove(id);
                        ew.put(id, new EmployeeWorkDTO(id));
                        System.out.println("변경을 완료하였습니다.");
                    }
                    break;
                default:
                    System.out.println("다시 선택해 주세요.");
                    break;
            }

        } catch (NullPointerException e) {
            System.out.println("잘못된 사원 번호입니다.");
        }
    }

    private EmployeeDTO findEmployee(int id) {
        return employees.get(id);
    }

    public void deleteEmployee() {
        System.out.println("퇴직 사원 입력");
        System.out.print("사원 번호 > ");
        int id = Integer.parseInt(sc.nextLine());
        try {
            employees.remove(id);
            System.out.println("사원 목록에서 해당 사원을 삭제하였습니다.");
        } catch (NullPointerException e) {
            System.out.println("잘못된 사원 번호입니다.");
        }
    }

    public int selectNum() {
        int num = -1;
        out: while (true) {
            System.out.print("선택 >> ");
            num = Integer.parseInt(sc.nextLine());
            if (num > -1 && num < 8) {
                break out;
            }
        }
        return num;
    }

    public void printMenu() {
        String menu = "[사원 관리 프로그램]\n"
                + "1. 신입 사원 입력\n"
                + "2. 사원 조회\n"
                + "3. 사원 정보 수정\n"
                + "4. 퇴직 사원 입력\n\n"
                + "[외근 업무 처리 현황 문서 작성 프로그램]\n"
                + "5. 파일 읽기\n"
                + "6. 파일 정보 처리\n"
                + "7. 파일 저장\n\n"
                + "0. 프로그램 종료\n\n";

        System.out.print(menu);
    }

    public boolean selectMenu(int menuNumber, ExcuteApp e) {
        switch (menuNumber) {
            case 1:
                insertEmployee();
                return true;
            case 2:
                printEmployeeList();
                return true;
            case 3:
                updateEmployeeInformation();
                return true;
            case 4:
                deleteEmployee();
                return true;
            case 5:
                // 파일 읽기
                fc.readFile();
                return true;
            case 6:
                // 파일 처리하기
                fc.runFile();
                return true;
            case 7:
                // 파일 저장
                fc.printFile(e);
                return true;
            case 0:

                stopApp();
                return false;
            default:
                return true;
        }
    }

    private void stopApp() {
        sc.close();
        System.out.println("프로그램을 종료 합니다.");
    }

}
