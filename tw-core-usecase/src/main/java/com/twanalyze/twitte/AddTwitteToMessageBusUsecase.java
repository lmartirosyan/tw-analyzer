package com.twanalyze.twitte;

import com.twanalyzer.entity.EntityWrapper;
import com.twanalyzer.entity.StreamDataBean;
import com.twanalyzer.repasitory.StreamData;

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
     * Use case for pushing data to message bus
     * currently using kafka
     * @param bean
     */
    public void add(StreamDataBean bean){
        String aggTimestamp = bean.getTimestamp() / 60000 + "";
        String key=getKey("",bean.getName());
        entityWrapper.getMessageBus().send(key, aggTimestamp);


    }
}
