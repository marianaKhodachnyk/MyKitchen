package com.example.mariana.kitchenassistant.events;


import com.example.mariana.kitchenassistant.model.RecipeInfo;

public class LoadRecipeInfoEvent {

    public RecipeInfo recipeInfo;

    public LoadRecipeInfoEvent(RecipeInfo recipeInfo) {
        this.recipeInfo = recipeInfo;
    }
}
