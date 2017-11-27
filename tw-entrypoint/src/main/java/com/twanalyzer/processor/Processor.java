package com.twanalyzer.processor;

import com.twitter.hbc.core.Client;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;

/**
 *
 */
public interface Processor {

    void init(Properties properties);

    void process(Client client, BlockingQueue<String> queue);

}
