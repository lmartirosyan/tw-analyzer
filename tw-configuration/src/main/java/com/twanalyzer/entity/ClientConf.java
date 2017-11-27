package com.twanalyzer.entity;

import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.httpclient.auth.Authentication;

import java.util.concurrent.BlockingQueue;

/**
 * Client configuration bean
 * keeps twitter client configurations
 */
public class ClientConf {
    private StatusesFilterEndpoint endpoint;
    private BlockingQueue<String> queue;
    private Authentication auth;
    private String name;

    public StatusesFilterEndpoint getEndpoint() {
        return endpoint;
    }
    public Authentication getAuth() {
        return auth;
    }
    public BlockingQueue<String> getQueue() {
        return queue;
    }

    public String getName() {
        return name;
    }


    private ClientConf(Builder builder) {
        this.endpoint=builder.endpoint;
        this.queue=builder.queue;
        this.auth=builder.auth;
        this.name=builder.name;
    }

    public static class Builder {
        private StatusesFilterEndpoint endpoint;
        private BlockingQueue<String> queue;
        private Authentication auth;
        private String name;


        public Builder(StatusesFilterEndpoint endpoint,  BlockingQueue<String> queue, Authentication auth){
            this.endpoint=endpoint;
            this.queue=queue;
            this.auth=auth;
        }
        public Builder name(String val) {
            this.name = val;
            return this;
        }

        public ClientConf build() {
            return new ClientConf(this);
        }
    }
}
