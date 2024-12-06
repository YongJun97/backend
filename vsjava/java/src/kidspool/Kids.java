package kidspool;

public class Kids {
    
    private String name;
    private String place;
    private int time;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public Kids(String name, String place, int time) {
        this.name = name;
        this.place = place;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Kids [name=" + name + ", place=" + place + ", time=" + time + "]";
    }
}
