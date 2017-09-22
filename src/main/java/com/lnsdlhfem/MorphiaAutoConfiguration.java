package com.lnsdlhfem;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * morphia配置
 *
 * @ClassName: MorphiaAutoConfiguration
 * @author: songpeng
 * @date: 2017/9/22 10:10
 */
@Configuration
@AutoConfigureAfter(MongoAutoConfiguration.class)
public class MorphiaAutoConfiguration {

    @Autowired
    private MongoClient mongoClient;

    @Bean
    public Datastore datastore() throws ClassNotFoundException {
        Morphia morphia = new Morphia();
        ClassPathScanningCandidateComponentProvider entityScanner = new ClassPathScanningCandidateComponentProvider(true);
        entityScanner.addIncludeFilter(new AnnotationTypeFilter(Entity.class));
        for (BeanDefinition candidate : entityScanner.findCandidateComponents("com.lnsdlhfem")) {
            morphia.map(Class.forName(candidate.getBeanClassName()));
        }

        return morphia.createDatastore(mongoClient, "");
    }
}
