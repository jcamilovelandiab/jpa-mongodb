package eci.cosw.factory;

import eci.cosw.config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class DatabaseFactory {

    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
    private static MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

    public static MongoOperations getMongoOperation(){
        return mongoOperation;
    }

}
