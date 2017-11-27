package com.twanalyzer.processor;

import com.twanalyze.twitte.AddTwitteUsecase;
import com.twanalyzer.entity.StreamDataBean;
import com.twitter.hbc.core.Client;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;

public class DirectRedisProcessor extends ClientProcessor implements Processor {

    private DirectRedisProcessor() {
    }
    /**
     *  Inits DB CONN
     * @param properties
     */
    public void init(Properties properties){
        streamData.init(properties);
    }

    public static DirectRedisProcessor getInstance(){
      return new DirectRedisProcessor();
    }

    /**
     * Starts stream pushing Redis to data
     * @param client
     * @param queue
     */
    @Override
    public void process(Client client, BlockingQueue<String> queue) {

        while (!client.isDone()) {
            StreamDataBean bean = ClientProcessor.getInstance().getStreamDataBean(client, queue);
            AddTwitteUsecase.getInstance(entityWrapper).add(bean);

        }

    }
}
