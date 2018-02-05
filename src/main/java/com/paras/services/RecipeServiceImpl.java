package com.paras.services;

import com.paras.domain.Recipe;
import com.paras.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @Override
    public Set<Recipe> getRecipes() {
       try{
           Set<Recipe> recipeSet=new HashSet<>();
           recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
           return recipeSet;
       }

       catch (Exception exception){
           System.out.println("Exception caught in service");
           System.out.println(exception.getMessage());
           throw exception;
       }


    }
}
