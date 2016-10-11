package com.varian.ois.sample.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.axonframework.domain.EventMessage;
import org.axonframework.eventhandling.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gbt1220 on 9/27/2016.
 */
@Configuration
@AnnotationDriven
public class CQRSInfrastructureConfig {

    @Bean
    public CommandBus commandBus() {
        return new SimpleCommandBus();
    }

    @Bean
    public CommandGateway commandGateway() {
        return new DefaultCommandGateway(commandBus());
    }

    @Bean
    public EventBus eventBus() {
        return new SimpleEventBus();
    }
/*
    @Bean
    public Cluster normalCluster() {
        SimpleCluster simpleCluster = new SimpleCluster("simpleCluster");
        return simpleCluster;
    }

    @Bean
    public ClusterSelector clusterSelector() {
        Map<String, Cluster> clusterMap = new HashMap<>();
        clusterMap.put("com.varian.ois.sample.*.eventhandler", normalCluster());
        return new ClassNamePrefixClusterSelector(clusterMap);
    }

    @Bean
    public EventBusTerminal terminal() {
        return new EventBusTerminal() {
            @Override
            public void publish(EventMessage... events) {
                normalCluster().publish(events);
            }
            @Override
            public void onClusterCreated(Cluster cluster) {

            }
        };
    }

    @Bean
    public EventBus clusteringEventBus() {
        ClusteringEventBus clusteringEventBus = new ClusteringEventBus(clusterSelector(), terminal());
        return clusteringEventBus;
    }*/

/*
    @Bean
    public MongoClient mongo() throws UnknownHostException {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Bean
    public MongoTemplate eventMongoTemplate() throws UnknownHostException {
        return new DefaultMongoTemplate(mongo(), "axonexploring", "domainevents", "snapshotevents",(String)null, (char[])null);
//        return new DefaultMongoTemplate(mongo());
    }

    @Bean
    public EventStore eventStore() throws UnknownHostException {
        return new MongoEventStore(eventMongoTemplate());
    }

    @Bean
    public EventBusTerminal terminal() {
        return new EventBusTerminal() {
            @Override
            public void publish(EventMessage... events) {
                normalCluster().publish(events);
            }
            @Override
            public void onClusterCreated(Cluster cluster) {

            }
        };
    }

    @Bean
    public EventBus clusteringEventBus() {
        ClusteringEventBus clusteringEventBus = new ClusteringEventBus(clusterSelector(), terminal());
        return clusteringEventBus;
    }

    @Bean
    public Repository<Account> accountEventSourcingRepository() throws UnknownHostException {

        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(Account.class, eventStore());
        eventSourcingRepository.setEventBus(clusteringEventBus());
        return eventSourcingRepository;
    }*/
}
