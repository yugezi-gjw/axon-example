package com.varian.ois.sample.exploringaxon.infrustructure.config;

import com.varian.ois.sample.config.CQRSInfrastructureConfig;
import com.varian.ois.sample.config.CQRSInfrastructureMongoDBConfig;
import com.varian.ois.sample.config.PersistenceInfrastructureConfig;
import com.varian.ois.sample.exploringaxon.commandhandler.CreditAccountHandler;
import com.varian.ois.sample.exploringaxon.commandhandler.DebitAccountHandler;
import com.varian.ois.sample.exploringaxon.model.Account;
import com.varian.ois.sample.exploringaxon.web.Db;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * Created by gbt1220 on 9/27/2016.
 */
@Configuration
@Import({
        CQRSInfrastructureConfig.class,
        CQRSInfrastructureMongoDBConfig.class,
        PersistenceInfrastructureConfig.class
})
@ImportResource("classpath:query-context.xml")
public class AccountConfig {
    @Autowired
    private EventStore eventStore;

    @Autowired
    private EventBus eventBus;

    @Bean
    public Repository<Account> accountEventSourcingRepository() {

        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(Account.class, eventStore);
        eventSourcingRepository.setEventBus(eventBus);
        return eventSourcingRepository;
    }

    @Bean
    public CreditAccountHandler creditAccountHandler() {
        CreditAccountHandler creditAccountHandler = new CreditAccountHandler();
        creditAccountHandler.setRepository(accountEventSourcingRepository());
        return creditAccountHandler;
    }

    @Bean
    public DebitAccountHandler debitAccountHandler() {
        DebitAccountHandler debitAccountHandler = new DebitAccountHandler();
        debitAccountHandler.setRepository(accountEventSourcingRepository());
        return debitAccountHandler;
    }

//    @Bean
//    public Db dbInit() {
//        Db db = new Db();
//        db.setRepository(accountEventSourcingRepository());
//        return db;
//    }
}
