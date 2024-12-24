package Project2_이슬;

public class Programs {
    private String pID;
    private String title;
    private String category;
    private String manager;
    private String teacher;
    private int max;
    private boolean confirmed;
    private boolean available;
    
    public Programs() {
    }

    public Programs(String pID, String title, String category, String manager, String teacher, int max) {
        this.pID = pID;
        this.title = title;
        this.category = category;
        this.manager = manager;
        this.teacher = teacher;
        this.max = max;
        confirmed = false;
        available = false;
    }

    public Programs(String pID, String title, String category, String manager, String teacher, int max,
            boolean confirmed, boolean available) {
        this.pID = pID;
        this.title = title;
        this.category = category;
        this.manager = manager;
        this.teacher = teacher;
        this.max = max;
        this.confirmed = confirmed;
        this.available = available;
    }

    public String getpID() {
        return pID;
    }
    public void setpID(String pID) {
        this.pID = pID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public boolean isConfirmed() {
        return confirmed;
    }
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return pID + "/" + title + "/" + category + "/" + manager
                + "/" + teacher + "/" + max + "/" + confirmed + "/" + available;
    }
}
