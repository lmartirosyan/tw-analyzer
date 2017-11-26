package com.twanalyzer.processor;

import com.twanalyze.twitte.AddTwitteToMessageBusUsecase;
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
     *  Inits DB CONN
     * @param properties
     */
    public void init(Properties properties){
        this.messageBus.init(properties);

    }
    @Override
    public void process(Client client, BlockingQueue<String> queue) {
        String message = null;
        try {
            while (!client.isDone()) {
                message = queue.take();
                JSONObject json = new JSONObject(message);
                long timestamp=json.getLong("timestamp_ms");
                String name=client.getName();
                AddTwitteToMessageBusUsecase.getInstance(entityWrapper).add(name, timestamp);

            }
        } catch (InterruptedException e) {
            logger.error("Error proccessing message form queue: "+message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
