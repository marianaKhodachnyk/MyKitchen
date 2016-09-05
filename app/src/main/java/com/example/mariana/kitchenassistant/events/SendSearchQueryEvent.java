package com.example.mariana.kitchenassistant.events;


public class SendSearchQueryEvent {

    private String query;

    public SendSearchQueryEvent(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
