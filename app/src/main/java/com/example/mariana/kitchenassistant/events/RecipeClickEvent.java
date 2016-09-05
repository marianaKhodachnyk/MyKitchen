package com.example.mariana.kitchenassistant.events;


public class RecipeClickEvent {
    private String id;

    public String getId() {
        return id;
    }

    public RecipeClickEvent(String id) {
        this.id = id;
    }
}
