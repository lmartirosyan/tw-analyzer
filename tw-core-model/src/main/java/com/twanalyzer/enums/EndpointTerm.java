package com.twanalyzer.enums;

public enum EndpointTerm {

    ARMENIA("Armenia"),

    GEORGIA("Georgia"),

    AZERBAIJAN("Azerbaijan");


    private String term;

    EndpointTerm(String term) {

        this.term = term;
    }

    public String get() {
        return this.term;
    }
}
