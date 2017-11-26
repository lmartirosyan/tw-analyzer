package com.twanalyzer.inject;


import com.twanalyzer.bus.MessageBusProvider;
import com.twanalyzer.db.StreamDataProvider;
import com.twanalyzer.repasitory.StreamData;
import com.twanalyzer.wrapper.LoggerProvider;

/**
 * Created by lilit on 6/29/17.
 */

public class Provider {

    private static Provider instance;
    private LoggerProvider loggerProvider;

    private StreamDataProvider streamDataProvider;

    private MessageBusProvider messageBusProvider;

    /**

     * Constructor for initialization
     */
    private Provider() {
    }

    /**
     * Method insures that class
     * is singletone
     *
     * @return
     */
    public static Provider getInstance() {
        if (instance == null) {
            instance = new Provider();
        }
        return instance;
    }

    /**
     * Returns Logger
     *
     * @return
     */
    public LoggerProvider getLoggerProvider() {
        return loggerProvider;
    }

    public void setLoggerProvider(LoggerProvider loggerProvider) {
        this.loggerProvider = loggerProvider;
    }
    public StreamDataProvider getStreamDataProvider() {
        return streamDataProvider;
    }

    public void setStreamDataProvider(StreamDataProvider streamDataProvider) {
        this.streamDataProvider = streamDataProvider;
    }

    public MessageBusProvider getMessageBusProvider() {
        return messageBusProvider;
    }

    public void setMessageBusProvider(MessageBusProvider messageBusProvider) {
        this.messageBusProvider = messageBusProvider;
    }

}
