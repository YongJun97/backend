package a1209.ArrayList1;

public class Student {
    private String name;
    private int age;
    private String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
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

    public String getStudentId() {
        return id;
    }

    public void setStudentId(String studentId) {
        this.id = studentId;
    }

    public Student(){
        
    }

    

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", studentId=" + id + "]";
    }

}
