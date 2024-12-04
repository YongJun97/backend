package out;

public class EmployeeDTO {
    int id;
    String name;
    String grade;
    String cell;

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public EmployeeDTO(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.cell = null;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + grade;
    }

}
