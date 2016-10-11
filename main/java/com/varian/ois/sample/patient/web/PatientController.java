package com.varian.ois.sample.patient.web;

import com.varian.ois.sample.common.OperationResult;
import com.varian.ois.sample.patient.command.CreatePatientCommand;
import com.varian.ois.sample.patient.command.UpdatePatientCommand;
import com.varian.ois.sample.patient.model.Patient;
import com.varian.ois.sample.patient.model.PatientEntity;
import com.varian.ois.sample.patient.repositories.PatientQueryRepository;
import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;

/**
 * Created by gbt1220 on 9/29/2016.
 */
@Controller
public class PatientController {

    @Autowired
    PatientQueryRepository patientQueryRepository;

    @Autowired
    private CommandGateway commandGateway;

    @RequestMapping("/patient/list")
    public String listPatients(Model model) {
        Iterable<PatientEntity> patients = patientQueryRepository.findAll();
        model.addAttribute("patients", patients);
        model.addAttribute("pat", new PatientEntity());
        return "patients";
    }

    @RequestMapping("/patient/save")
    @Transactional
    @ResponseBody
    public String savePatient(@RequestParam("patId") String patId, @RequestParam("patNameChinese") String patNameChinese,
                           @RequestParam("patNameEnglish") String patNameEnglish, @RequestParam("gender") String gender,
                           @RequestParam("birthday") String birthday, @RequestParam("idCard") String idCard,
                           @RequestParam("phone") String phone, @RequestParam("address") String address,
                           @RequestParam("allergy") String allergy) {
        PatientEntity patient = patientQueryRepository.findOne(patId);
        FutureCallback<OperationResult> callback = new FutureCallback<>();
        if (patient != null) {
            UpdatePatientCommand updatePatientCommand = new UpdatePatientCommand(patId, patNameChinese, patNameEnglish, gender,birthday,idCard,phone,address,allergy);
            commandGateway.send(updatePatientCommand, callback);
        } else {
            CreatePatientCommand createPatientCommand = new CreatePatientCommand(patId, patNameChinese, patNameEnglish, gender, birthday, idCard, phone, address, allergy);
//        commandGateway.send(createPatientCommand);
            commandGateway.send(createPatientCommand, callback);
        }
        try {
            OperationResult result = callback.get();
            if (result != null) {
                return result.getText();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping("/patient/find")
    @ResponseBody
    public PatientEntity findPatient(@RequestParam("patId") String patId) {
        PatientEntity patient = patientQueryRepository.findOne(patId);
//        Iterable<PatientEntity> patients = patientQueryRepository.findAll();
//        model.addAttribute("patients", patients);
//        model.addAttribute("pat", patient);
        return patient;
    }
}
