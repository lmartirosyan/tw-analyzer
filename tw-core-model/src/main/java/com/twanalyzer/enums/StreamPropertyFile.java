package com.twanalyzer.enums;

/**
 * Created by lilit on 7/7/17.
 */
public enum StreamPropertyFile {

    TW_ARMENIA_PROPS("tw-armenia.properties"),

    TW_GEORGIA_PROPS("tw-georgia.properties"),

    TW_AZERBAIJAN_PROPS("tw-azerbaijan.properties");


    private String file;

    StreamPropertyFile(String file) {

        this.file = file;
    }

    public String get() {
        return this.file;
    }
}
