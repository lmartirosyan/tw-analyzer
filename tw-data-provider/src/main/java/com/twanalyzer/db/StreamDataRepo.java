package com.twanalyzer.db;




import com.twanalyzer.enums.DBProperty;
import com.twanalyzer.repasitory.StreamData;
import com.twanalyzer.wrapper.Logger;
import com.twanalyzer.wrapper.LoggerWrapper;
import redis.clients.jedis.Jedis;

import java.util.Properties;


/**
 * Created by lilit.
 */
public class StreamDataRepo implements StreamData {

    private static Logger logger= LoggerWrapper.getInstance();


    private static StreamDataRepo instance;

    private  Jedis jedis=null;

    private StreamDataRepo() {

    }

    public static StreamDataRepo getInstance() {
        if (instance==null){
            instance =new StreamDataRepo();
        }
        return instance;
    }

    @Override
    public void init(Properties properties) {
        String host= properties.getProperty(DBProperty.HOST.get());
        int port= Integer.parseInt(properties.getProperty(DBProperty.PORT.get()));
        int dbIndex=Integer.parseInt(properties.getProperty(DBProperty.DB_INDEX.get()));
        this.jedis = new Jedis(host, port);
        this.jedis.select(dbIndex);

        logger.info("connected to redis by host: "+host+" port: "+port+" DB: "+jedis.getDB());
    }

    @Override
    public void close() {
        if(this.jedis.isConnected()){
            this.jedis.getClient().close();
        }
    }


    @Override
    public int get(String key) {
        return  Integer.parseInt(this.jedis.get(key));
    }


    @Override
    public void put(String key, long score, int value) {

    }

    /**
     * increments value
     * @param key
     */
    @Override
    public void incr(String key) {
       this.jedis.incr(key);
    }

    /**
     *  Flushes data from db
     */
    @Override
    public void flush() {
        this.jedis.flushAll();

    }

}
