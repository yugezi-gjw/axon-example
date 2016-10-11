package com.varian.ois.sample.patient.event;

/**
 * Created by gbt1220 on 10/11/2016.
 */
public class ScheduleCreatedEvent {
    private String patientId;
    private String diagnose;
    private String bodyPart;
    private String scheduleTime;
    private String terminal;
    private String course;

    public ScheduleCreatedEvent(String patientId, String diagnose, String bodyPart, String scheduleTime, String terminal, String course) {
        this.patientId = patientId;
        this.diagnose = diagnose;
        this.bodyPart = bodyPart;
        this.scheduleTime = scheduleTime;
        this.terminal = terminal;
        this.course = course;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
