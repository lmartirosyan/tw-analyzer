package com.twanalyzer.stream.client;

import com.twanalyzer.entity.ClientConf;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;

public class ClientBuilder {

    private ClientConf clientConf;

    /**
     *
     * @param clientConf
     */
    private ClientBuilder(ClientConf clientConf) {
        this.clientConf = clientConf;
    }

    /**
     *
     * @param clientConf
     * @return
     */
    public static ClientBuilder getInstance(ClientConf clientConf) {
        return new ClientBuilder(clientConf);
    }

    /**
     * Builds twitter application
     * configuration
     * @return
     */
    public Client build() {
        return new com.twitter.hbc.ClientBuilder()
                .hosts(Constants.STREAM_HOST)
                .endpoint(clientConf.getEndpoint())
                .authentication(clientConf.getAuth())
                .processor(new StringDelimitedProcessor(clientConf.getQueue()))
                .name(clientConf.getName())
                .build();
    }
}

