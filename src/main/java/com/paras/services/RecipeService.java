package com.paras.services;

import com.paras.domain.Recipe;

import javax.sound.midi.Receiver;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    public Recipe findById(long id);
}
