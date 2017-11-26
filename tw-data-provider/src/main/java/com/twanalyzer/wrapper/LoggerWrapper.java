package com.twanalyzer.wrapper;


/**
 * Created by lilit.
 */
public class LoggerWrapper implements Logger {
    private  static  LoggerWrapper instance;

    private   String prefix;

    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LoggerWrapper.class);


    private LoggerWrapper() {}

    /**
     * getInstance method insures that
     * class is singletone
     * @return
     */
    public static LoggerWrapper getInstance() {
        if (instance==null){
            instance =new LoggerWrapper();
        }
        return instance;
    }

    /**
     *
     * @param prefix
     */
    public  void prefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     *
     * @param msg
     */

    public void info(String msg) {
        logger.info(this.prefix+"-"+Thread.currentThread().getId()+" "+msg);
    }

    /**
     *
     * @param msg
     */
    public void debug(String msg) {

        logger.debug(this.prefix+"-"+Thread.currentThread().getId()+" "+msg);
    }

    /**
     *
      * @param msg
     */
    public void warn(String msg) {
        logger.warn(this.prefix+"-"+Thread.currentThread().getId()+" "+msg);
    }

    /**
     *
      * @param msg
     */
    public void error(String msg) {
        logger.error(this.prefix+"-"+Thread.currentThread().getId()+" "+msg);
    }

    /**
     *
     * @param msg
     * @param throwable
     */
    public void error(String msg, Throwable throwable) {
        logger.error(this.prefix+"-"+Thread.currentThread().getId()+" "+msg, throwable);
    }

    /**
     *
     * @param msg
     * @param o
     */
    public void error(String msg, Object o) {

    }


}