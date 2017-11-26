package com.twanalyzer.processor;

import com.twanalyzer.entity.EntityWrapper;
import com.twanalyzer.inject.Provider;
import com.twanalyzer.repasitory.MessageBus;
import com.twanalyzer.repasitory.StreamData;
import com.twanalyzer.wrapper.Logger;


public  class ClientProcessor{

    protected static final Provider provider= Provider.getInstance();

    protected EntityWrapper entityWrapper;

    protected Logger logger;

    protected  StreamData streamData;

    protected MessageBus messageBus;

    protected ClientProcessor(){
        this.entityWrapper =buildEntityWrapper(provider);
        this.logger=entityWrapper.getLogger();
        this.streamData=entityWrapper.getStreamData();
        this.messageBus=entityWrapper.getMessageBus();
    }

    /**
     *
     * @return
     */
    public static ClientProcessor getInstance(){

        return new ClientProcessor();
    }

    /**
     * @return
     */
    public static Provider getProvider() {
        return provider;
    }
    /**
     *
     * @param provider
     * @return
     */
    private EntityWrapper buildEntityWrapper(Provider provider) {
        return new EntityWrapper.Builder()
                .logger(provider.getLoggerProvider().getLogger())
                .StreamData(provider.getStreamDataProvider().getStreamData())
                .MessageBus(provider.getMessageBusProvider().getMessageBus())
                .build();
    }



}
