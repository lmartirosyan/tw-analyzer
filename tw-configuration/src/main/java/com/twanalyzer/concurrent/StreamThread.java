package com.twanalyzer.concurrent;

import com.twanalyzer.context.Context;
import com.twanalyzer.entity.ClientConf;
import com.twanalyzer.enums.Mode;
import com.twanalyzer.enums.StreamPropertyFile;
import com.twanalyzer.enums.TWProperty;
import com.twanalyzer.processor.Processor;
import com.twanalyzer.property.PropertyLoader;
import com.twanalyzer.stream.client.ClientBuilder;
import com.twanalyzer.stream.client.ClientConfiguration;
import com.twitter.hbc.core.Client;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StreamThread {
    /**
     * Runs threads for
     * stream data execution
     *
     */
    public static void runStreamThreads(){
        StreamPropertyFile[] propFiles = StreamPropertyFile.values();
        int counter = propFiles.length;
        /************running threads to connect Twitter stream api****************/
        while (counter>0) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            int index = --counter;
            executor.execute(() -> {
                Context cxt=Context.getInstance();
                Properties props = PropertyLoader.loadStreamProperties(propFiles[index]);
                Mode mode=Mode.valueOf(props.getProperty(TWProperty.PROCESSING_MODE.get()));
                cxt.setMode(mode);
                ClientConf clientConfiguration = ClientConfiguration.getConfiguration(props);
                Client client = ClientBuilder.getInstance(clientConfiguration).build();
                client.connect();
                Processor processor = cxt.getProcessor();
                processor.init(PropertyLoader.loadProperties(cxt.getStoragePropertyFile().get()));
                processor.process(client, clientConfiguration.getQueue());


            });

        }
    }
}
