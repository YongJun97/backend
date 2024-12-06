package project.football;

public class User {
    private String name;
    private String age;
    private String phone;
    
    public User(String name, String age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   

    
}
