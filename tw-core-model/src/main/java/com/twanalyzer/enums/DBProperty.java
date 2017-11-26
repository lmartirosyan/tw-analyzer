package com.twanalyzer.enums;

public enum DBProperty {
    HOST("redis.host"),

    PORT("redis.port"),

    DB_INDEX("db.index"),

    CLIENT_NAME("redis.client.name");




    private String prop;

    DBProperty(String prop) {

        this.prop = prop;
    }

    public String get() {
        return this.prop;
    }
}
