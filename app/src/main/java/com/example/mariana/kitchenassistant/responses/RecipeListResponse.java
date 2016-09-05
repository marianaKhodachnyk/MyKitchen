package com.example.mariana.kitchenassistant.responses;

import java.util.List;

import com.example.mariana.kitchenassistant.model.Recipe;

public class RecipeListResponse {
    private List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
