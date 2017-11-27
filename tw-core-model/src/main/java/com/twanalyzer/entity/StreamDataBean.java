package com.twanalyzer.entity;

public class StreamDataBean {

    private long timestamp;

    private String name;

    private String text;

    public long getTimestamp() {
        return timestamp;
    }

    public String getName() {
        return name;
    }
    public String getText() {
        return text;
    }


    private StreamDataBean(Builder builder) {

        this.timestamp=builder.timestamp;
        this.name=builder.name;
        this.text=builder.text;

    }

    public static class Builder {
        private long timestamp;
        private String name;
        private String text;

        public Builder timestamp(long val) {
            this.timestamp = val;
            return this;
        }

        public Builder name(String val) {
            this.name = val;
            return this;
        }

        public Builder text(String val) {
            this.name = val;
            return this;
        }

        public StreamDataBean build() {
            return new StreamDataBean(this);
        }

    }
}
