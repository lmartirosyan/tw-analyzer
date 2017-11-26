package com.twanalyze.twitte;

import com.twanalyzer.entity.EntityWrapper;

public class AddTwitteToMessageBusUsecase extends UseCase {

    private static AddTwitteToMessageBusUsecase addTwitteToMessageBusUsecase;
    /**
     * private constructor
     */
    private AddTwitteToMessageBusUsecase(EntityWrapper entityWrapper) {
        this.entityWrapper=entityWrapper;
    }

    /**
     * Returns singletone instance of
     * ThresholdUseCase
     */
    public static AddTwitteToMessageBusUsecase getInstance(EntityWrapper entityWrapper) {
        if (addTwitteToMessageBusUsecase == null) {
            addTwitteToMessageBusUsecase = new AddTwitteToMessageBusUsecase(entityWrapper);
        }
        initWrappers(entityWrapper);
        return addTwitteToMessageBusUsecase;
    }

    /**
     *
     * @param name
     * @param timestamp
     */
    public void add(String name, long timestamp){
        String aggTimestamp = timestamp / 60000 + "";
        String key=getKey("",name);
        entityWrapper.getMessageBus().send(key, aggTimestamp);


    }
}
