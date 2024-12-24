package Project2_이슬;

public class Members {

    private String id;
    private String pw;
    private String name;
    private String type;
    private boolean orgMem;
    private int bYear;
    private String phone;
    private String address;
    private String email;

    public Members(String id) {
        this.id = id;
    }

    public Members(String id, String pw, String name, int bYear, String phone,
            String address, String email) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        type = "";
        orgMem = false;
        this.bYear = bYear;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Members(String id, String pw, String name, String type, boolean orgMem, int bYear, String phone,
            String address, String email) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.type = type;
        this.orgMem = orgMem;
        this.bYear = bYear;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public boolean isOrgMem() {
        return orgMem;
    }
    public void setOrgMem(boolean orgMem) {
        this.orgMem = orgMem;
    }
    public int getBYear() {
        return bYear;
    }
    public void setBYear(int bYear) {
        this.bYear = bYear;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "," + pw + ","+ name + "," + type + "," + orgMem + "," + bYear + "," + phone + "," + address + "," + email;
    }     
}
