package com.paras.services;

import com.paras.domain.Recipe;
import com.paras.repositories.RecipeRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRpository recipeRpository;
    @Override
    public Set<Recipe> getRecipes() {
       Set<Recipe> recipeSet=new HashSet<>();
       recipeRpository.findAll().iterator().forEachRemaining(recipeSet::add);
       return recipeSet;

    }
}
