package com.twanalyze.twitte;

import com.twanalyzer.entity.EntityWrapper;
import com.twanalyzer.entity.StreamDataBean;

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
     *  Use case for storing
     *  data to  DB
     *  currently we are using Redis
     * @param bean
     */
    public void add(StreamDataBean bean){
        String aggTimestamp = bean.getTimestamp() / 60000 + "";
        String key=getKey("_",bean.getName(), aggTimestamp);
        streamData.incr(key);
        logger.info("stored by key"+key);

    }
}
