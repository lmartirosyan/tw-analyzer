package com.twanalyzer.stream.client;

import com.twanalyzer.entity.ClientConf;
import com.twanalyzer.enums.Mode;
import com.twanalyzer.enums.StoragePropertyFile;
import com.twanalyzer.enums.StreamPropertyFile;
import com.twanalyzer.enums.TWProperty;
import com.twanalyzer.inject.Provider;
import com.twanalyzer.processor.ClientProcessor;
import com.twanalyzer.context.Context;
import com.twanalyzer.processor.Processor;
import com.twanalyzer.property.PropertyLoader;
import com.twanalyzer.wrapper.LoggerWrapper;
import com.twitter.hbc.core.Client;
import inject.Inject;

import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientStart {

    public static void main(String[] args) {
        LoggerWrapper logger = LoggerWrapper.getInstance();
        logger.prefix("--TW-ANALYZER ");
        logger.info("starting client");
        Provider provider = ClientProcessor.getProvider();
        Inject.inject(provider);
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
                    logger.debug("---starting client by: " + props.getProperty(TWProperty.TRACK_TERM.get())+ " term");
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
