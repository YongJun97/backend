package out;

public class WorkDTO {
    String name;
    int month;
    int day;
    String place;
    int category;
    String strCategory;
    boolean am;

    public boolean isAm() {
        return am;
    }

    public void setAm(boolean am) {
        this.am = am;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public WorkDTO(String name, int month, int day, String place, String category, Boolean am) {
        this.name = name;
        this.month = month;
        this.day = day;
        this.place = place;
        this.strCategory = category;
        this.am = am;
    }

}
