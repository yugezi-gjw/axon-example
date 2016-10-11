package com.varian.ois.sample.patient.commandhandler;

import com.varian.ois.sample.common.OperationResult;
import com.varian.ois.sample.patient.command.CreatePatientCommand;
import com.varian.ois.sample.patient.command.UpdatePatientCommand;
import com.varian.ois.sample.patient.common.PatientCreatedResult;
import com.varian.ois.sample.patient.common.PatientUpdatedResult;
import com.varian.ois.sample.patient.model.Patient;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by gbt1220 on 9/28/2016.
 */
@Component
public class PatientCommandHandler {
    private Repository<Patient> repository;

    @CommandHandler
    public OperationResult handleCreatePatient(CreatePatientCommand createPatientCommand) {
        Patient patient = new Patient(createPatientCommand.getPatientId(),
                createPatientCommand.getPatientNameChinese(),
                createPatientCommand.getPatientNameEnglish(),
                createPatientCommand.getGender(),
                createPatientCommand.getBirthday(),
                createPatientCommand.getIdCard(),
                createPatientCommand.getPhoneNumber(),
                createPatientCommand.getAddress(),
                createPatientCommand.getAllergyHistory());
        repository.add(patient);
        return new PatientCreatedResult();
    }

    @CommandHandler
    public OperationResult handleUpdatePatient(UpdatePatientCommand updatePatientCommand) {
        Patient patient = repository.load(updatePatientCommand.getPatientId());
        patient.updatePatient(updatePatientCommand.getPatientNameChinese(),
                updatePatientCommand.getPatientNameEnglish(),
                updatePatientCommand.getGender(),
                updatePatientCommand.getBirthday(),
                updatePatientCommand.getIdCard(),
                updatePatientCommand.getPhoneNumber(),
                updatePatientCommand.getAddress(),
                updatePatientCommand.getAllergyHistory());

        return new PatientUpdatedResult();
    }

    @Autowired
    public void setRepository(Repository<Patient> repository) {
        this.repository = repository;
    }
}
