package com.twanalyzer.repasitory;


import com.twanalyzer.repasitory.connection.Connection;

public interface StreamData extends Connection {

    int get(String key);

    void put(String key, long score, int value);

    void incr(String key);

    void flush();
}
