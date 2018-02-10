package com.paras.services;

import com.paras.domain.Recipe;
import com.paras.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.HashSet;
import java.util.Set;
import static org.mockito.Mockito.*;
public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository);

    }
    @Test
    public void getRecipe() throws Exception{
            Recipe recipe=new Recipe();
            Set recipeData=new HashSet();
            recipeData.add(recipe);
            when(recipeService.getRecipes()).thenReturn(recipeData);

            Set<Recipe> recipes=recipeService.getRecipes();
            assertEquals(recipes.size(),1);

            verify(recipeRepository,times(1)).findAll();


    }

    @Test
    public void findById() {
        Recipe recipe=new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional= Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }
}