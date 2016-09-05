package com.example.mariana.kitchenassistant.model;


import java.util.List;

public class RecipeInfo {

    private String title;
    private String publisher;
    private List<String> ingredients;
    private String image_url;

    public RecipeInfo(String title, String publisher, List<String> ingredients, String image_url) {
        this.title = title;
        this.publisher = publisher;
        this.ingredients = ingredients;
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }


    public List<String> getIngredients() {
        return ingredients;
    }


    public String getImage_url() {
        return image_url;
    }

}
