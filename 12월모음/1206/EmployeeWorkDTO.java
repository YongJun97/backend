package out;

import java.util.HashMap;
import java.util.Map;

public class EmployeeWorkDTO {

    int id;
    Map<Integer, WorkDTO> copy_court = new HashMap<>();
    Map<Integer, WorkDTO> copy_prosecution = new HashMap<>();
    Map<Integer, WorkDTO> sentencing_am = new HashMap<>();
    Map<Integer, WorkDTO> sentencing_pm = new HashMap<>();
    Map<Integer, WorkDTO> submission_am = new HashMap<>();
    Map<Integer, WorkDTO> submission_pm = new HashMap<>();
    Map<Integer, WorkDTO> execution = new HashMap<>();
    double submission_count;

    public EmployeeWorkDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, WorkDTO> getCopy_court() {
        return copy_court;
    }

    public void setCopy_court(Map<Integer, WorkDTO> copy_court) {
        this.copy_court = copy_court;
    }

    public Map<Integer, WorkDTO> getCopy_prosecution() {
        return copy_prosecution;
    }

    public void setCopy_prosecution(Map<Integer, WorkDTO> copy_prosecution) {
        this.copy_prosecution = copy_prosecution;
    }

    public Map<Integer, WorkDTO> getSentencing_am() {
        return sentencing_am;
    }

    public void setSentencing_am(Map<Integer, WorkDTO> sentencing_am) {
        this.sentencing_am = sentencing_am;
    }

    public Map<Integer, WorkDTO> getSentencing_pm() {
        return sentencing_pm;
    }

    public void setSentencing_pm(Map<Integer, WorkDTO> sentencing_pm) {
        this.sentencing_pm = sentencing_pm;
    }

    public Map<Integer, WorkDTO> getSubmission_am() {
        return submission_am;
    }

    public void setSubmission_am(Map<Integer, WorkDTO> submission_am) {
        this.submission_am = submission_am;
    }

    public Map<Integer, WorkDTO> getSubmission_pm() {
        return submission_pm;
    }

    public void setSubmission_pm(Map<Integer, WorkDTO> submission_pm) {
        this.submission_pm = submission_pm;
    }

    public Map<Integer, WorkDTO> getExecution() {
        return execution;
    }

    public void setExecution(Map<Integer, WorkDTO> execution) {
        this.execution = execution;
    }

    public double getSubmission_count() {
        return submission_count;
    }

    public void setSubmission_count(double submission_count) {
        this.submission_count = submission_count;
    }

}
