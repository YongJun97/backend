package a1204;

import java.util.ArrayList;
import java.util.List;

class Student{
    private int id;
    private String name;
    private int age;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
    }


}


public class List2 {
    public static void main(String[] args) {
        // ArrayList 생성
        List<Student> studentList = new ArrayList<>();

        // 객체추가
        studentList.add(new Student(101, "Alice", 20));
        studentList.add(new Student(102, "Bob", 22));
        studentList.add(new Student(103, "Charlie", 21));


        // ArrayList 출력
        System.out.println("Student List 출력 : ");
        printList(studentList);

        // 특정인덱스의 객체 가져오기
        System.out.println("\n 특정 인덱스(1)의 Student 정보");
        Student student = studentList.get(1); // 인덱스 1번 객체
        // 객체 하나를 가져 오려면 Student 객체로 가져와야 함

        // String name = studentList.get(1).getName();
        // name과 같이 특정적 으로 하나만 가져올 때는 String int등
        System.out.println(student);

        // 모든 student 이름만 출력
        System.out.println("\n모든 학생의 이름 출력 : ");
        for(Student s : studentList){
            System.out.println(s.getName());
        }

        // 데이터 추가
        // 104,"David" , 23
        
        studentList.add(new Student(104,"David",23));
        printList(studentList);
        
        // 데이터 변경
        System.out.println("\n특정 학생 변경");
        updateStudent(studentList, 102 , "Robert" , 25);
        printList(studentList);
        
        // 데이터 삭제
        System.out.println("\n특정 학생 삭제");
        deleteStudent(studentList, 103);
        printList(studentList);
                
        // 특정 학생 검색
        System.out.println("\n 특정 학생 검색");
        Student searchedStudent = findStudentById(studentList, 104);
                System.out.println(searchedStudent != null ? searchedStudent :"학생을 찾을 수 없습니다.");
        
        
        
        
        }
                
                
        
        
        
                // ArrayList 출력 메서드
        private static void printList(List<Student> studentList) {
            for(Student student : studentList){
                System.out.println(student);
            }
        }

        // 학생정보 업데이트
        private static void updateStudent(List<Student> studentList, int id, String NewName, int NewAge) {
            // 리스트를 돌면서 id가 같은 것을 찾아서 이름 과 나이를 변경
            for(Student s : studentList){
                if(s.getId() == id){  // studentList 중 매개변수 입력된 id와 같으면
                    s.setName(NewName); // Robert
                    s.setAge(NewAge);   // 25
                    System.out.println("학생 ID "+ id + "정보가 수정되었습니다.");
                    return;
                }
            }
            System.out.println("학생 ID" + id + "을(를) 찾을 수 없습니다.");
        }

        private static void deleteStudent(List<Student> studentList, int id) {
            for(int i = 0; i < studentList.size(); i++){
             if(studentList.get(i).getId() == id){
                 studentList.remove(i);
                 System.out.println("학생 ID "+id+"정보가 삭제 되었습니다.");
                 return;
             }
            }
            System.out.println("학생 ID" + id + "을(를) 찾을 수 없습니다.");
         }

         private static Student findStudentById(List<Student> studentList, int id) {
            for(Student s : studentList){
                if(s.getId() == id){  // studentList 중 매개변수 입력된 id와 같으면
                    
                    return s;
                }
            }
            return null;             
         }
}
