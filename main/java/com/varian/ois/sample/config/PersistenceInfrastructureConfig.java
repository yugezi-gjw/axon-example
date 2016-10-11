package com.varian.ois.sample.config;

import com.mongodb.MongoClient;
import org.axonframework.eventstore.mongo.DefaultMongoTemplate;
import org.axonframework.eventstore.mongo.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * Created by gbt1220 on 9/26/2016.
 */
@Component
public class PersistenceInfrastructureConfig {
    @Bean
//    @Profile("mongodb")
    public MongoClient mongo() throws UnknownHostException {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Bean
//    @Profile("mongodb")
    public MongoTemplate eventMongoTemplate() throws UnknownHostException {
        return new DefaultMongoTemplate(mongo(), "axonexploring", "domainevents", "snapshotevents",(String)null, (char[])null);
//        return new DefaultMongoTemplate(mongo());
    }

    @Bean
//    @Profile("mongodb")
    public org.springframework.data.mongodb.core.MongoTemplate springMongoTemplate() throws UnknownHostException {
        return new org.springframework.data.mongodb.core.MongoTemplate(mongo(), "axonexploring");
    }

}
