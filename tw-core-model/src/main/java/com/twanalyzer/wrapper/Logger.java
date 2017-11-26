package com.twanalyzer.wrapper;

/**
 * Created by lilit.
 */
public interface Logger {
    void prefix(String prefix);

    void info(String msg);

    void debug(String msg);

    void warn(String msg);

    void error(String msg);

    void error(String msg, Throwable throwable);

    void error(String msg, Object o);


}