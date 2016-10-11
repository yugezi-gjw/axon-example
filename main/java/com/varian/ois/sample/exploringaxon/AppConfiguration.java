package com.varian.ois.sample.exploringaxon;

import org.axonframework.contextsupport.spring.AnnotationDriven;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Dadepo Aderemi.
 */
@Configuration
@AnnotationDriven
public class AppConfiguration {
/*
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("")
                .url("jdbc:h2:mem:exploredb")
                .driverClassName("org.h2.Driver")
                .build();
    }

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
    public org.springframework.data.mongodb.core.MongoTemplate mongoTemplate() throws UnknownHostException {
        return new org.springframework.data.mongodb.core.MongoTemplate(mongo(), "axonexploring");
    }

    @Bean
    public EventStore eventStore() {
        try {
            return new MongoEventStore(eventMongoTemplate());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public SimpleCommandBus commandBus() {
        SimpleCommandBus simpleCommandBus = new SimpleCommandBus();
        return simpleCommandBus;
    }

    @Bean
    public Cluster normalCluster() {
        SimpleCluster simpleCluster = new SimpleCluster("simpleCluster");
        return simpleCluster;
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

    @Bean
    public ClusterSelector clusterSelector() {
        Map<String, Cluster> clusterMap = new HashMap<>();
        clusterMap.put("exploringaxon.eventhandler", normalCluster());
        clusterMap.put("exploringaxon.replay", replayCluster());
        return new ClassNamePrefixClusterSelector(clusterMap);
    }


    @Bean
    public EventBus clusteringEventBus() {
        ClusteringEventBus clusteringEventBus = new ClusteringEventBus(clusterSelector(), terminal());
        return clusteringEventBus;
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
    public DefaultCommandGateway commandGateway() {
        return new DefaultCommandGateway(commandBus());
    }

    @Bean
    public Repository<Account> eventSourcingRepository() {
//        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(Account.class, jdbcEventStore());
        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(Account.class, eventStore());
        eventSourcingRepository.setEventBus(clusteringEventBus());
        return eventSourcingRepository;
    }

//    @Bean
//    public Repository<Patient> patientEventSourcingRepository() {
//        EventSourcingRepository eventSourcingRepository = new EventSourcingRepository(Patient.class, eventStore());
//        eventSourcingRepository.setEventBus(clusteringEventBus());
//        return eventSourcingRepository;
//    }*/
}
