package project.football;

public class Reservation {
    private String matchNum;
    private String userName;
    private String userAge;
    private String userPhone;
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchNum() {
        return matchNum;
    }

    public void setMatchNum(String matchNum) {
        this.matchNum = matchNum;
    }

    


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Reservation(String matchNum, String userName, String userAge, String userPhone, String password) {
        this.matchNum = matchNum;
        this.userName = userName;
        this.userAge = userAge;
        this.userPhone = userPhone;
        this.password = password;
    }

   


    
}
