package com.twanalyzer.twitte;

import com.twanalyze.twitte.AddTwitteUsecase;
import com.twanalyzer.UsecaseTest;
import com.twanalyzer.entity.StreamDataBean;
import org.junit.Test;

public class AddTwitteUsecaseTest extends UsecaseTest{

    @Test
    public void testAdd(){
        StreamDataBean firstBean = new StreamDataBean.Builder()
                .name(country)
                .timestamp(timestamp)
                .build();

        StreamDataBean secondBean = new StreamDataBean.Builder()
                .name(country)
                .timestamp(timestamp+1)
                .build();

        AddTwitteUsecase useCase = AddTwitteUsecase.getInstance(entityWrapper);
                useCase.add(firstBean);
        useCase.add(secondBean);
        String key = String.join("_", country, timestamp / 60000 + "");
        int result = entityWrapper.getStreamData().get(key);
       assertEquals(2,result);
    }

}
