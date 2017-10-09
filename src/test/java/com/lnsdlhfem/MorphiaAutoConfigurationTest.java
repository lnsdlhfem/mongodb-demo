package com.lnsdlhfem;

import org.junit.Assert;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MorphiaAutoConfigurationTest {

    @Autowired
    private MorphiaAutoConfiguration morphiaAutoConfiguration;

    @Test
    public void test() throws ClassNotFoundException {
        Datastore ds = morphiaAutoConfiguration.datastore();
        Assert.assertNotNull(ds);
    }
}
