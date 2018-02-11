package com.paras.services;

import com.paras.commands.RecipeCommand;
import com.paras.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    public Recipe findById(long id);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
