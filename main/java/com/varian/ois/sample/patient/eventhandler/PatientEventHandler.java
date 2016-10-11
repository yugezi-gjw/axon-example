package com.varian.ois.sample.patient.eventhandler;

import com.varian.ois.sample.patient.event.PatientCreatedEvent;
import com.varian.ois.sample.patient.event.PatientUpdatedEvent;
import com.varian.ois.sample.patient.model.PatientEntity;
import com.varian.ois.sample.patient.repositories.PatientQueryRepository;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gbt1220 on 9/28/2016.
 */
@Component
public class PatientEventHandler {
    private PatientQueryRepository patientQueryRepository;

    @EventHandler
    public void handlePatientCreation(PatientCreatedEvent patientCreatedEvent) {
        savePatientEntity(patientCreatedEvent.getPatientId(), patientCreatedEvent.getAddress(), patientCreatedEvent.getAllergyHistory(), patientCreatedEvent.getBirthday(), patientCreatedEvent.getGender(), patientCreatedEvent.getIdCard(), patientCreatedEvent.getPatientNameChinese(), patientCreatedEvent.getPatientNameEnglish(), patientCreatedEvent.getPhoneNumber());
    }

    @EventHandler
    public void handlePatientUpdate(PatientUpdatedEvent patientUpdatedEvent) {
        savePatientEntity(patientUpdatedEvent.getPatientId(), patientUpdatedEvent.getAddress(), patientUpdatedEvent.getAllergyHistory(), patientUpdatedEvent.getBirthday(), patientUpdatedEvent.getGender(), patientUpdatedEvent.getIdCard(), patientUpdatedEvent.getPatientNameChinese(), patientUpdatedEvent.getPatientNameEnglish(), patientUpdatedEvent.getPhoneNumber());
    }

    private void savePatientEntity(String patientId, String address, String allergyHistory, String birthday, String gender, String idCard, String patientNameChinese, String patientNameEnglish, String phoneNumber) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setIdentifier(patientId);
        patientEntity.setAddress(address);
        patientEntity.setAllergyHistory(allergyHistory);
        patientEntity.setBirthday(birthday);
        patientEntity.setGender(gender);
        patientEntity.setIdCard(idCard);
        patientEntity.setPatientId(patientId);
        patientEntity.setPatientNameChinese(patientNameChinese);
        patientEntity.setPatientNameEnglish(patientNameEnglish);
        patientEntity.setPhoneNumber(phoneNumber);

        patientQueryRepository.save(patientEntity);
    }

    @Autowired
    public void setPatientQueryRepository(PatientQueryRepository patientQueryRepository) {
        this.patientQueryRepository = patientQueryRepository;
    }
}
