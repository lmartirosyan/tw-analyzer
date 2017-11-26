package com.twanalyzer.context;

import com.twanalyzer.enums.Mode;
import com.twanalyzer.enums.StoragePropertyFile;
import com.twanalyzer.processor.DirectRedisProcessor;
import com.twanalyzer.processor.KafkaProcessor;
import com.twanalyzer.processor.Processor;

import java.util.Properties;

public class Context {

    private Context(){}

    public static Context getInstance(){
        return new Context();
    }

    Processor processor;

    private StoragePropertyFile storagePropertyFile;

    /**
     * Set a Strategy or algorithm in the Context
     * @param mode
     */
    public void setMode(Mode mode)
    {
        switch (mode){
            case KAFKA_MODE:
                this.processor = KafkaProcessor.getInstance();
                this.storagePropertyFile= StoragePropertyFile.KAFKA_PROPS;
                break;
            default:
                 this.processor= DirectRedisProcessor.getInstance();
                this.storagePropertyFile= StoragePropertyFile.REDIS_PROPS;
                 break;
        }

    }

    /**
     *
     * @return
     */
    public Processor getProcessor()
    {
       return this.processor;
    }

    public StoragePropertyFile getStoragePropertyFile() {
        return storagePropertyFile;
    }


}
