package com.twanalyzer.enums;

public enum TWProperty {

    CONSUMER_KEY("consumer.key"),

    CONSUMER_SECRET("consumer.secret"),

    ACCESS_TOKEN("access.token"),

    ACCESS_TOKEN_SECRET("access.token.secret"),

    NAME("name"),

    QUEUE_SIZE("queue.size"),

    TRACK_TERM("track.term"),

    PROCESSING_MODE("processing.mode");


    private String prop;

    TWProperty(String prop) {

        this.prop = prop;
    }

    public String get() {
        return this.prop;
    }
}
