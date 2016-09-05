package com.example.mariana.kitchenassistant.model;


public class Recipe {

    private String recipe_id;
    private String image_url;
    private String title;

    public Recipe(String recipe_id, String image_url, String title) {
        this.recipe_id = recipe_id;
        this.image_url = image_url;
        this.title = title;
    }

    public String getRecipe_id() {
        return recipe_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
