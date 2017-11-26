package com.twanalyzer.enums;

public enum StoragePropertyFile {
    KAFKA_PROPS("kafka.properties"),

    REDIS_PROPS("redis.properties"),

    REDIS_TEST_PROPS("redis-test.properties");


    private String file;

    StoragePropertyFile(String file) {

        this.file = file;
    }

    public String get() {
        return this.file;
    }
}
