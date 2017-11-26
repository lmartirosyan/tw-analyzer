package com.twanalyzer.entity;


import com.twanalyzer.repasitory.MessageBus;
import com.twanalyzer.repasitory.StreamData;
import com.twanalyzer.wrapper.Logger;

/**
 * Created by lilit.
 */
public class EntityWrapper {

    private Logger logger;

    private StreamData streamData;

    private MessageBus messageBus;

    public Logger getLogger() {
        return logger;
    }

    public StreamData getStreamData() {
        return streamData;
    }

    public MessageBus getMessageBus() {
        return messageBus;
    }


    protected EntityWrapper(){}

    protected EntityWrapper(Builder builder) {

        this.logger=builder.logger;
        this.streamData=builder.streamData;
        this.messageBus=builder.messageBus;

    }

    public static class Builder {
        private Logger logger;
        private StreamData streamData;
        private MessageBus messageBus;


        public Builder logger(Logger val) {
            this.logger = val;
            return this;
        }

        public Builder StreamData(StreamData val) {
            this.streamData = val;
            return this;
        }

        public Builder MessageBus(MessageBus val) {
            this.messageBus = val;
            return this;
        }
        public EntityWrapper build() {
            return new EntityWrapper(this);
        }

    }

}
