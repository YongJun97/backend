package a1209.ArrayList1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentEx {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();
    // 1번째 방법 
        // Student s1 = new Student("Alice",20,"S001");
        // Student s2 = new Student("Bob",22,"S002");
        // Student s3 = new Student("Charile",19,"S003");

        // students.add(s1);
        // students.add(s2);
        // students.add(s3);


    // 2번째 방법
    students.add(new Student("Alice",20,"S001"));
    students.add(new Student("Bob",22,"S002"));
    students.add(new Student("Charile",19,"S003"));

        Student s4 = new Student();

        s4.setName("Tom");
        s4.setAge(22);
        s4.setStudentId("S004");
        students.add(s4);

        boolean run = true;
        while (run) {
            System.out.println("---학생 관리 프로그램---");
            System.out.println("1. 학생 추가하기");
            System.out.println("2. 학생들 리스트 보기");
            System.out.println("3. 학생정보수정");
            System.out.println("4. 학생정보삭제");
            System.out.println("5. Exit");
            System.out.print("너의 선택은? >>");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    // 학생을 입력받아 넣고 리스트에 추가하는 내용을 작성하세요
                // 1번 방법 (이게 좀 더 좋은듯)
                    System.out.println("추가 할 학생 이름: ");
                    String name = sc.nextLine();
                    System.out.println("추가 할 학생의 나이: ");
                    int age = sc.nextInt(); // 숫자입력할때 20 \n(개행문자)
                    sc.nextLine();  // next() 나 nextInt() 같은 메서드가 입력버퍼에 남긴 \n
                    System.out.println("추가할 학생의 아이디: ");
                    String id = sc.nextLine();
                    students.add(new Student(name,age,id));
                    System.out.println("추가가 완료 되었습니다.");
                // 2번 방법    
                    // Student s5 = new Student();
                    // System.out.println("이름을 입력: ");
                    // s5.setName(sc.nextLine());
                    // System.out.println("나이를 입력: ");
                    // s5.setAge(sc.nextInt());
                    // System.out.println("id를 입력: ");
                    // s5.setStudentId(sc.nextLine());
                    // students.add(s5);
                    // System.out.println("추가가 완료 되었습니다.");
                    break;
                case 2:
                    // 학생리스트 보여주기
                    if(students.isEmpty()){ // students.isEmpty() = 학생 리스트가 없으면
                        System.out.println("보여줄 학생 리스트 없음");
                    }else{
                        for(Student student : students){
                            System.out.println(student);
                        }
                    }
                    break; // break는 현재의 (while)반복문만 빠져나감 
                case 3:
                    System.out.println("업데이트할 학생 id를 입력해주세요");
                    String updateId = sc.nextLine();
                    boolean found = false;
                    for(Student student : students){
                        if(student.getStudentId().equalsIgnoreCase(updateId)){
                            System.out.println("새로운 이름: ");
                            student.setName(sc.nextLine());
                            System.out.println("새로운 나이: ");
                            student.setAge(sc.nextInt());
                            sc.nextLine();
                            System.out.println("학생정보 수정 성공");
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("찾는 학생이 없습니다.");
                    }



                    break;
                case 5:
                    System.out.println("프로그램종료");
                    sc.close();
                    // System.exit(0);
                    //return; // 현재메서드 (main) 전체를 종료, 호출된 곳으로 제어를 반환
                    run = false; // while의 run이 true 이기 때문에 run을 false로 바꾸면 while문이 정지함
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    
            }
        }

    }
}
