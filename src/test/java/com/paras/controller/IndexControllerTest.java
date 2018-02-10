package com.paras.controller;

import com.paras.domain.Recipe;
import com.paras.services.RecipeService;
import com.paras.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    RecipeServiceImpl recipeService;
    @Mock
    Model model;

    IndexController indexController;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        indexController=new IndexController(recipeService);
    }

    @Test
    public void testMockMvc() throws Exception{
        MockMvc mockMvc= MockMvcBuilders.standaloneSetup(indexController).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOk()).andExpect(view().name("index"));
    }
    @Test
    public void getIndexPage(){
        Set<Recipe> recipes=new HashSet<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());
        when(recipeService.getRecipes()).thenReturn(recipes);
        ArgumentCaptor<Set<Recipe>> argumentCaptor=ArgumentCaptor.forClass(Set.class);
        String viewName=indexController.index(model);
        assertEquals("index",viewName);
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        Set<Recipe> setInController=argumentCaptor.getValue();
        assertEquals(2,setInController.size());


    }
}