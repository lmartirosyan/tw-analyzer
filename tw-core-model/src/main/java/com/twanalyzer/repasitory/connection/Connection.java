package com.twanalyzer.repasitory.connection;

import java.util.Properties;

public interface Connection {
    /**
     * init connection with the metadata storage
     */
    void init(Properties properties);

    /**
     * close connection with metadata storage
     */
    void close();
}
