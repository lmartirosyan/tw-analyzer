package com.twanalyzer.enums;

public enum Mode {
   KAFKA_MODE("kafka"),

   DIRECT_REDIS_MODE("com.twanalyzer.enums.Mode.redis");

    private String mode;

    Mode(String mode) {

        this.mode = mode;
    }

    public String get() {
        return this.mode;
    }
}
