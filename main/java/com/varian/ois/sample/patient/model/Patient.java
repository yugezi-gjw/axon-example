package com.varian.ois.sample.patient.model;

import com.varian.ois.sample.patient.event.PatientCreatedEvent;
import com.varian.ois.sample.patient.event.PatientUpdatedEvent;
import com.varian.ois.sample.patient.event.ScheduleCreatedEvent;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

/**
 * Created by gbt1220 on 9/28/2016.
 */
public class Patient extends AbstractAnnotatedAggregateRoot {
    @AggregateIdentifier
    private String patientId;

    public Patient() {
    }

    public Patient(String patientId, String patientNameChinese, String patientNameEnglish, String gender, String birthday, String idCard, String phoneNumber, String address, String allergyHistory) {
        apply(new PatientCreatedEvent(patientId, patientNameChinese, patientNameEnglish,gender,birthday,idCard,phoneNumber,address,allergyHistory));
    }

    public void updatePatient(String patientNameChinese, String patientNameEnglish, String gender, String birthday, String idCard, String phoneNumber, String address, String allergyHistory) {
        apply(new PatientUpdatedEvent(this.patientId, patientNameChinese, patientNameEnglish, gender, birthday, idCard, phoneNumber, address, allergyHistory));
    }

    @EventSourcingHandler
    public void applyPatientCreation(PatientCreatedEvent patientCreatedEvent) {
        this.patientId = patientCreatedEvent.getPatientId();
    }

    @Override
    public Object getIdentifier() {
        return this.patientId;
    }

    public void schedule(String diagnose, String bodyPart, String scheduleTime, String terminal, String course) {
        apply(new ScheduleCreatedEvent(patientId, diagnose, bodyPart, scheduleTime, terminal, course));
    }
}
