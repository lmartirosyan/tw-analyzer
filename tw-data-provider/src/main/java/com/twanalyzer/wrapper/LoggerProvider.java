package com.twanalyzer.wrapper;

import javax.inject.Inject;

/**
 * Provides implementation of logger
 *
 * Created by lilit.
 */
public class LoggerProvider {
    private LoggerProvider instance;

    private Logger logger;

    @Inject
    private LoggerProvider(Logger logger) {
        this.logger = logger;
    }

    public LoggerProvider getInstance(Logger logger) {
        if (instance == null) {
            instance = new LoggerProvider(logger);
        }
        return instance;

    }

    public Logger getLogger() {
        return logger;
    }

}
