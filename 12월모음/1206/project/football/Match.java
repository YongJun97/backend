package project.football;

public class Match {
    private String team1;
    private String team2;
    private String date;
    private String time;
    private String matchNum;

    public Match(String team1, String team2, String date, String time, String matchNum) {
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.time = time;
        this.matchNum = matchNum;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getMatchNum() {
        return matchNum;
    }
    

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMatchNum(String matchNum) {
        this.matchNum = matchNum;
    }

 

   
}