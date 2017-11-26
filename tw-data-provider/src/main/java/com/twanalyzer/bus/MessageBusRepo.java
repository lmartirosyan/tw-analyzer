package com.twanalyzer.bus;

import com.twanalyzer.repasitory.MessageBus;
import com.twanalyzer.wrapper.Logger;
import com.twanalyzer.wrapper.LoggerWrapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MessageBusRepo implements MessageBus {


    private static Logger logger= LoggerWrapper.getInstance();


    private static MessageBusRepo instance;

    private KafkaProducer<String, String> producer=null;

    private MessageBusRepo() {

    }

    public static MessageBusRepo getInstance() {

        return new MessageBusRepo();
    }

    @Override
    public void init(Properties properties) {
        this.producer=new KafkaProducer<>(properties);

        logger.info("Kafka producer is connected...");
    }

    @Override
    public void close() {
        if(producer!=null){
            producer.close();
        }
    }
    @Override
    public void send(String key, String value) {
        ProducerRecord<String, String> record = new ProducerRecord<>("twitte",key, value);
            producer.send(record);
            logger.info("message pushed to kafka by key: "+key+" value: "+value);
    }
}
