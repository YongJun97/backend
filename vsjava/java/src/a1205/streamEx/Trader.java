package a1205.streamEx;

public class Trader {
    private String name;
    private String city;

    // getter
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    // 생성자
    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
    // toString
    @Override
    public String toString() {
        return "Trader [name=" + name + ", city=" + city + "]";
    }

}
