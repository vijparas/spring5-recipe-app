package com.paras.services;

import com.paras.commands.RecipeCommand;
import com.paras.converters.RecipeCommandToRecipe;
import com.paras.converters.RecipeToRecipeCommand;
import com.paras.domain.Recipe;
import com.paras.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository,RecipeCommandToRecipe recipeCommandToRecipe,RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe=recipeCommandToRecipe;
        this.recipeToRecipeCommand=recipeToRecipeCommand;

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

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    @Override
    public Recipe findById(long id) {
        Optional<Recipe> recipeOptional=recipeRepository.findById(id);
        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found");

        }
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachRecipe=recipeCommandToRecipe.convert(recipeCommand);
        Recipe savedRecipe=recipeRepository.save(detachRecipe);
        return recipeToRecipeCommand.convert(savedRecipe);

    }
}
