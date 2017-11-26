package com.twanalyzer.stream.client;

import com.google.common.collect.Lists;
import com.twanalyzer.entity.ClientConf;
import com.twanalyzer.enums.TWProperty;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Properties;
public class ClientConfiguration{


    public static ClientConf getConfiguration(Properties properties){

        String consumerKey= properties.getProperty(TWProperty.CONSUMER_KEY.get());
        String consumerSecret=properties.getProperty(TWProperty.CONSUMER_SECRET.get());
        String token=properties.getProperty(TWProperty.ACCESS_TOKEN.get());
        String secret=properties.getProperty(TWProperty.ACCESS_TOKEN_SECRET.get());
        String queueSize=properties.getProperty(TWProperty.QUEUE_SIZE.get());
        String trackTerm=properties.getProperty(TWProperty.TRACK_TERM.get());
        String name=properties.getProperty(TWProperty.NAME.get());

        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(Lists.newArrayList(trackTerm));
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(Integer.parseInt(queueSize));
        Authentication auth = new OAuth1(consumerKey, consumerSecret, token, secret);
        return new ClientConf.Builder(endpoint,queue,auth)
                .name(name)
                .build();

    }

}
