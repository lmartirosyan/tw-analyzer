package com.twanalyzer.repasitory;

import com.twanalyzer.repasitory.connection.Connection;

public interface MessageBus extends Connection {

    void send(String key, String value);
}
