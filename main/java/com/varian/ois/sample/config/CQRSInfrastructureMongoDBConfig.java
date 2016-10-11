package com.varian.ois.sample.config;

import org.axonframework.eventhandling.Cluster;
import org.axonframework.eventhandling.SimpleCluster;
import org.axonframework.eventhandling.replay.DiscardingIncomingMessageHandler;
import org.axonframework.eventhandling.replay.IncomingMessageHandler;
import org.axonframework.eventhandling.replay.ReplayingCluster;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.management.EventStoreManagement;
import org.axonframework.eventstore.mongo.MongoEventStore;
import org.axonframework.eventstore.mongo.MongoTemplate;
import org.axonframework.unitofwork.NoTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * Created by gbt1220 on 9/26/2016.
 */
@Configuration
//@Profile("mongodb")
@Import(PersistenceInfrastructureConfig.class)
public class CQRSInfrastructureMongoDBConfig {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    public EventStore eventStore() {
        return new MongoEventStore(mongoTemplate);
    }

    @Bean
    public Cluster replay() {
        SimpleCluster simpleCluster = new SimpleCluster("replayCluster");
        return simpleCluster;
    }

    @Bean
    public ReplayingCluster replayCluster() {
        IncomingMessageHandler incomingMessageHandler = new DiscardingIncomingMessageHandler();
        EventStoreManagement eventStoreManagement = (EventStoreManagement) eventStore();
        return new ReplayingCluster(replay(), eventStoreManagement, new NoTransactionManager(),0,incomingMessageHandler);
    }
}
