package com.lnsdlhfem;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

@Component
public class MongoInit {

    private final MongoDbFactory mongo;

    public MongoInit(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

}
