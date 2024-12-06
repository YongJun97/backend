package entity;

public class User {
    @Override
    public String toString() {
        return "User [userID=" + userID + ", passWord=" + "*****" + ", userName=" + userName + ", isAdmin=" + isAdmin
                + "]";
    }

    private String userID;
    private String passWord;
    private String userName;
    private boolean isAdmin;

    public User(String userID, String passWord, String name, boolean isAdmin) {
        this.userID = userID;
        this.passWord = passWord;
        this.userName = name;
        this.isAdmin = isAdmin;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void changeUserPassword(String pw) {
        this.passWord = pw;
    }
}


