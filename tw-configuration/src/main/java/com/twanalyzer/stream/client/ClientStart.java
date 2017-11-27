package com.twanalyzer.stream.client;

import com.twanalyzer.concurrent.StreamThread;
import com.twanalyzer.inject.Inject;
import com.twanalyzer.inject.Provider;
import com.twanalyzer.processor.ClientProcessor;
import com.twanalyzer.wrapper.LoggerWrapper;

/**
 *  Main class
 *  Runs 3 threads for each country
 *  for twitte processing
 *
 */
public class ClientStart {

    public static void main(String[] args) {
        LoggerWrapper logger = LoggerWrapper.getInstance();
        logger.prefix("--TW-ANALYZER ");
        logger.info("starting client");
        Provider provider = ClientProcessor.getProvider();
        Inject.inject(provider);
        StreamThread.runStreamThreads();

    }


}
