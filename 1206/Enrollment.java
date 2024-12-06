package Project2_이슬;

public class Enrollment {
    private String eID;
    private String uID;
    private String pID;
    
    public Enrollment() {
    }

    public Enrollment(String eID, String uID, String pID) {
        this.eID = eID;
        this.uID = uID;
        this.pID = pID;
    }
    
    public String geteID() {
        return eID;
    }
    public void seteID(String eID) {
        this.eID = eID;
    }
    public String getuID() {
        return uID;
    }
    public void setuID(String uID) {
        this.uID = uID;
    }
    public String getpID() {
        return pID;
    }
    public void setpID(String pID) {
        this.pID = pID;
    }

    @Override
    public String toString() {
        return eID + "," + uID + "," + pID;
    }

}
