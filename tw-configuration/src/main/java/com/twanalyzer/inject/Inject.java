package com.twanalyzer.inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.twanalyzer.bus.MessageBusProvider;
import com.twanalyzer.db.StreamDataProvider;
import com.twanalyzer.wrapper.Logger;
import com.twanalyzer.wrapper.LoggerProvider;
import com.twanalyzer.wrapper.LoggerWrapper;


/**
 * Created by lilit.
 */
public class Inject {

    private static Logger logger = LoggerWrapper.getInstance();

    /**
     * Injects all the wrappers
     *
     * @param provider
     */
    public static void inject(Provider provider){
        Inject.injectLogger(provider);
        Inject.injectStreamData(provider);
        Inject.injectMessageBus(provider);
    }
    /**
     * Injects logger by guice
     * Currently using apache log4j
     *
     * @param provider
     */
    public static void injectLogger(Provider provider) {
        logger.info("logger injecting");
        Injector injector = Guice.createInjector(new InjectionModule());
        LoggerProvider loggerProvider = injector.getInstance(LoggerProvider.class);
        provider.setLoggerProvider(loggerProvider);
        logger.info("logger injected");
    }

    /**
     * Injects logger by guice
     * Currently using apache log4j
     *
     * @param provider
     */
    public static void injectStreamData(Provider provider) {
        logger.info("StreamData injecting");
        Injector injector = Guice.createInjector(new InjectionModule());
        StreamDataProvider streamDataProvider = injector.getInstance(StreamDataProvider.class);
        provider.setStreamDataProvider(streamDataProvider);
        logger.info("StreamData injected");
    }
    /**
     * Injects MessageBus by guice
     * Currently using apache Kafka
     *
     * @param provider
     */
    public static void injectMessageBus(Provider provider) {
        logger.info("MessageBus injecting");
        Injector injector = Guice.createInjector(new InjectionModule());
        MessageBusProvider messageBusProvider = injector.getInstance(MessageBusProvider.class);
        provider.setMessageBusProvider(messageBusProvider);
        logger.info("MessageBus injected");
    }


}
