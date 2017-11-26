package com.twanalyzer.twitte;

import com.twanalyze.twitte.AddTwitteUsecase;
import com.twanalyzer.UsecaseTest;
import org.junit.Test;

public class AddTwitteUsecaseTest extends UsecaseTest{

    @Test
    public void testAdd(){

        AddTwitteUsecase useCase = AddTwitteUsecase.getInstance(entityWrapper);
                useCase.add(country, timestamp);
        useCase.add(country, timestamp+1);
        String key = String.join("_", country, timestamp / 60000 + "");
        int result = entityWrapper.getStreamData().get(key);
       assertEquals(2,result);
    }

}
