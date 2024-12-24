package mini.chelsea;

public class Player {
    private int id;
    private int number;
    private String position;
    private String name;
    private int shoot;
    private int shootAccuracy;
    private int pass;
    private int passAccuracy;

    public Player(int id, int number, String position, String name, int shoot, int shootAccuracy, int pass, int passAccuracy) {
        this.id = id;
        this.number = number;
        this.position = position;
        this.name = name;
        this.shoot = shoot;
        this.shootAccuracy = shootAccuracy;
        this.pass = pass;
        this.passAccuracy = passAccuracy;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getShoot() {
        return shoot;
    }

    public int getShootAccuracy() {
        return shootAccuracy;
    }

    public int getPass() {
        return pass;
    }

    public int getPassAccuracy() {
        return passAccuracy;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShoot(int shoot) {
        this.shoot = shoot;
    }

    public void setShootAccuracy(int shootAccuracy) {
        this.shootAccuracy = shootAccuracy;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public void setPassAccuracy(int passAccuracy) {
        this.passAccuracy = passAccuracy;
    }

    @Override
    public String toString() {
        return "Player ID: " + id + ", 번호: " + number + ", 이름: " + name + ", 포지션: " + position +
                ", 슛: " + shoot + ", 슛 정확도: " + shootAccuracy + 
                ", 패스: " + pass + ", 패스 정확도: " + passAccuracy;
    }
}

    
    
