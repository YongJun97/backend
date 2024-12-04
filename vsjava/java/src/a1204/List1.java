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


public class List1 {
    public static void main(String[] args) {
        // ArrayList 생성
        List<Student> studentList = new ArrayList<>();

        // 객체추가
        studentList.add(new Student(101, "Alice", 20));
        studentList.add(new Student(102, "Bob", 22));
        studentList.add(new Student(103, "Charlie", 21));


        // ArrayList 출력
        System.out.println("Student List 출력 : ");
        for(Student student : studentList){
            System.out.println(student);
        }

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
        

    }
}
