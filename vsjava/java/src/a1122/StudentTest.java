package a1122;

public class StudentTest {
    public static void main(String[] args) {
        Student park = new Student(2019122104,"Park");
        Student kim = new Student(2019122106,"Kim");
        Student lee = new Student(2019122107,"Lee");
        Student yun = new Student(2019122107,"Yun");
        System.out.printf("Student 객체의 수 : %d", Student.count);
    }
}
class Student{
    static int count = 0; 
    // 인스턴스 변수
    int id;
    String name;

    public Student(int id, String name) {
        Student.count++;
        this.id = id;
        this.name = name;
    }
}
