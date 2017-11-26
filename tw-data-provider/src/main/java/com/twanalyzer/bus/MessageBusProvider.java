package com.twanalyzer.bus;

import com.twanalyzer.repasitory.MessageBus;

import javax.inject.Inject;

public class MessageBusProvider {
    private static MessageBusProvider instance;
    private MessageBus messageBus;

    /**
     * @param messageBus
     */
    @Inject
    private MessageBusProvider(MessageBus messageBus) {
        this.messageBus = messageBus;
    }

    /**
     * Factory method created instance of processor
     *
     * @param messageBus
     * @return
     */
    public MessageBusProvider getInstance(MessageBus messageBus) {
        if (instance == null)
            instance=new MessageBusProvider(messageBus);
        return instance;

    }

    /**
     * @return
     */
    public MessageBus getMessageBus() {
        return messageBus;
    }
}
