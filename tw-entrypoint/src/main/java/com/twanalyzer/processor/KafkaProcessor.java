package com.twanalyzer.processor;

import com.twanalyze.twitte.AddTwitteToMessageBusUsecase;
import com.twanalyzer.entity.StreamDataBean;
import com.twitter.hbc.core.Client;
import twitter4j.JSONException;
import twitter4j.JSONObject;

import java.util.Properties;
import java.util.concurrent.BlockingQueue;

public class KafkaProcessor extends ClientProcessor implements Processor {



    private KafkaProcessor() {
    }

    public static KafkaProcessor getInstance(){
        return new KafkaProcessor();
    }
    /**
     *  Inits Message bus CONN
     * @param properties
     */
    public void init(Properties properties){
        this.messageBus.init(properties);

    }

    /**
     * Starts stream pushing Redis to data
     *
     * @param client
     * @param queue
     */
    @Override
    public void process(Client client, BlockingQueue<String> queue) {

            while (!client.isDone()) {
                StreamDataBean bean = ClientProcessor.getInstance().getStreamDataBean(client, queue);
                AddTwitteToMessageBusUsecase.getInstance(entityWrapper).add(bean);

            }

    }
}
