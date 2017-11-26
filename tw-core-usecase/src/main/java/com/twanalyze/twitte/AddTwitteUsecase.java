package com.twanalyze.twitte;

import com.twanalyzer.entity.EntityWrapper;

public class AddTwitteUsecase extends  UseCase{

    private static AddTwitteUsecase addTwitteUsecase;

    /**
     * private constructor
     */
    private AddTwitteUsecase(EntityWrapper entityWrapper) {
        this.entityWrapper=entityWrapper;
    }

    /**
     * Returns singletone instance of
     * ThresholdUseCase
     */
    public static AddTwitteUsecase getInstance(EntityWrapper entityWrapper) {
        if (addTwitteUsecase == null) {
            addTwitteUsecase = new AddTwitteUsecase(entityWrapper);
        }
        initWrappers(entityWrapper);
        return addTwitteUsecase;
    }

    /**
     *
     * @param name
     * @param timestamp
     */
    public void add(String name, long timestamp){
        String aggTimestamp = timestamp / 60000 + "";
        String key=getKey("_",name, aggTimestamp);
        streamData.incr(key);
        logger.info("stored by key"+key);

    }
}
