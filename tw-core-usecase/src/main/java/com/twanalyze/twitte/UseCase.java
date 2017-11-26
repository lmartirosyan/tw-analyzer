package com.twanalyze.twitte;


import com.twanalyzer.entity.EntityWrapper;
import com.twanalyzer.repasitory.StreamData;
import com.twanalyzer.wrapper.Logger;

/**
 * Created by lilit.
 */
public class UseCase {
    private  static UseCase instance;

    protected static Logger logger;

    protected static StreamData streamData;

    protected static EntityWrapper entityWrapper;



    /**
     *
     * @return
     */
    public static UseCase getInstance() {
        if(instance==null){
            instance=new UseCase();
        }
        return  instance;
    }

    /***
     *
     * @param separator
     * @param keys
     * @return
     */
    protected    String getKey(String separator, String... keys){
        return String.join(separator, keys);

    }

    /**
     * inits third party wrappers
     *
     * @param entityWrapper
     */
    protected static void initWrappers(EntityWrapper entityWrapper) {
        if (entityWrapper != null) {
            logger=entityWrapper.getLogger();
            streamData=entityWrapper.getStreamData();

        }
    }
}
