package de.nordakademie.persistence.common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Required;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongodbFactory implements FactoryBean<DB> {

    private MongoClient mongoClient;
    private String databaseName;

    @Override
    public DB getObject() {
        return mongoClient.getDB(databaseName);
    }

    @Override
    public Class<DB> getObjectType() {
        return DB.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Required
    public void setMongoClient(final MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Required
    public void setDatabaseName(final String databaseName) {
        this.databaseName = databaseName;
    }
}
