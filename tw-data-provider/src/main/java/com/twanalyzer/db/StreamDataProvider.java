package com.twanalyzer.db;



import com.twanalyzer.repasitory.StreamData;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * StreamDataProvider
 * Propose of class is to act
 * with stream data repository
 * to lower levels (use case)
 * <p>
 * which  has implementation of
 * MetaData storage
 * <p>
 * Created by lilit.
 */
@Singleton
public class StreamDataProvider {

    private static StreamDataProvider instance;
    private StreamData streamData;

    /**
     * @param streamData
     */
    @Inject
    private StreamDataProvider(StreamData streamData) {
        this.streamData = streamData;
    }

    /**
     * Factory method created instance of processor
     *
     * @param streamData
     * @return
     */
    public StreamDataProvider getInstance(StreamData streamData) {
        if (instance == null) {
            instance = new StreamDataProvider(streamData);
        }
        return instance;

    }

    /**
     * @return
     */
    public StreamData getStreamData() {
        return streamData;
    }
}
