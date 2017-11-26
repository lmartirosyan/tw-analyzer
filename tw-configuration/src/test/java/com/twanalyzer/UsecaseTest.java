package com.twanalyzer;

import com.twanalyzer.db.StreamDataRepo;
import com.twanalyzer.entity.EntityWrapper;
import com.twanalyzer.enums.DBProperty;
import com.twanalyzer.enums.StoragePropertyFile;
import com.twanalyzer.inject.Provider;
import com.twanalyzer.processor.ClientProcessor;
import com.twanalyzer.property.PropertyLoader;
import inject.Inject;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;

import java.util.Properties;

public class UsecaseTest extends TestCase{
    protected EntityWrapper entityWrapper;
    protected String country= "Belgium";
    protected   long timestamp=1511700958764l;
    private StreamDataRepo repo= StreamDataRepo.getInstance();

    @Before
    protected void setUp(){
        Provider provider = ClientProcessor.getProvider();
        Inject.inject(provider);
        Properties props = PropertyLoader.loadProperties(StoragePropertyFile.REDIS_TEST_PROPS.get());
        repo.init(props);

        entityWrapper = new EntityWrapper.Builder()
                .logger(provider.getLoggerProvider().getLogger())
                .StreamData(provider.getStreamDataProvider().getStreamData())
                .build();
    }

    @After
    protected void tearDown(){
        repo.flush();
        repo.close();
    }
}
