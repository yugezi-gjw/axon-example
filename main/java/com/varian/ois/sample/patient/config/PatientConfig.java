package com.varian.ois.sample.patient.config;

import com.varian.ois.sample.config.CQRSInfrastructureConfig;
import com.varian.ois.sample.config.CQRSInfrastructureMongoDBConfig;
import com.varian.ois.sample.config.PersistenceInfrastructureConfig;
import com.varian.ois.sample.exploringaxon.model.Account;
import com.varian.ois.sample.patient.commandhandler.PatientCommandHandler;
import com.varian.ois.sample.patient.model.Patient;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by gbt1220 on 9/29/2016.
 */
@Configuration
@Import({
        CQRSInfrastructureConfig.class,
        CQRSInfrastructureMongoDBConfig.class,
        PersistenceInfrastructureConfig.class
})
@ImportResource("classpath:query-context.xml")
public class PatientConfig {
    @Autowired
    private EventStore eventStore;

    @Autowired
    private EventBus eventBus;

    @Bean
    public Repository<Patient> patientEventSourcingRepository() {

        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(Patient.class, eventStore);
        eventSourcingRepository.setEventBus(eventBus);
        return eventSourcingRepository;
    }

    @Bean
    public PatientCommandHandler patientCommandHandler() {
        PatientCommandHandler patientCommandHandler = new PatientCommandHandler();
        patientCommandHandler.setRepository(patientEventSourcingRepository());
        return patientCommandHandler;
    }
}
