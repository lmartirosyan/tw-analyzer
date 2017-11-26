package com.twanalyzer.processor;

import com.twanalyze.twitte.AddTwitteUsecase;
import com.twitter.hbc.core.Client;
import twitter4j.JSONException;
import twitter4j.JSONObject;

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
    @Override
    public void process(Client client, BlockingQueue<String> queue) {
        String message = null;
        try {
            while (!client.isDone()) {
                message = queue.take();
                JSONObject json = new JSONObject(message);
                long timestamp=json.getLong("timestamp_ms");
                String name=client.getName();
                AddTwitteUsecase.getInstance(entityWrapper).add(name,timestamp);

            }
        } catch (InterruptedException e) {
            logger.error("Error proccessing message form queue: "+message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
