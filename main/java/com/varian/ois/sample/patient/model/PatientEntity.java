package com.varian.ois.sample.patient.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

/**
 * Created by gbt1220 on 9/28/2016.
 */
@Entity
public class PatientEntity {
    @Id
    @javax.persistence.Id
    private String identifier;
    private String patientId;
    private String patientNameChinese;
    private String patientNameEnglish;
    private String gender;
    private String birthday;
    private String idCard;
    private String phoneNumber;
    private String address;
    private String allergyHistory;

    public PatientEntity() {
        this.identifier = "";
        this.patientId="";
        this.patientNameChinese="";
        this.patientNameEnglish="";
        this.gender="";
        this.birthday="";
        this.idCard="";
        this.phoneNumber="";
        this.address="";
        this.allergyHistory="";
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientNameChinese() {
        return patientNameChinese;
    }

    public void setPatientNameChinese(String patientNameChinese) {
        this.patientNameChinese = patientNameChinese;
    }

    public String getPatientNameEnglish() {
        return patientNameEnglish;
    }

    public void setPatientNameEnglish(String patientNameEnglish) {
        this.patientNameEnglish = patientNameEnglish;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAllergyHistory() {
        return allergyHistory;
    }

    public void setAllergyHistory(String allergyHistory) {
        this.allergyHistory = allergyHistory;
    }
}
