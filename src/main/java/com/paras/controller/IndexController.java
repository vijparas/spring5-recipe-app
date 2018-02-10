    package com.paras.controller;

    import com.paras.domain.Category;
    import com.paras.domain.Recipe;
    import com.paras.domain.UnitOfMeasure;
    import com.paras.repositories.CategoryRepository;
    import com.paras.repositories.UnitOfMeasureRepository;
    import com.paras.services.RecipeService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.RequestMapping;

    import java.util.Optional;
    import java.util.Set;

    @Controller
    public class IndexController {
        @Autowired
        private CategoryRepository categoryRepository;
        @Autowired
        private UnitOfMeasureRepository unitOfMeasureRepository;
        @Autowired
        private RecipeService recipeService;

        @RequestMapping({"/","index"})
        public String index(Model model){
            Set<Recipe> recipeSet=recipeService.getRecipes();
            model.addAttribute("recipes",recipeSet);
            return "index";

    }
    }
