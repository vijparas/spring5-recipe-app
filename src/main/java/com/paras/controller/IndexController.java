package com.paras.controller;

import com.paras.domain.Category;
import com.paras.domain.UnitOfMeasure;
import com.paras.repositories.CategoryRepository;
import com.paras.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller


public class IndexController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;
@RequestMapping({"/","index"})
    public String index(){
    Optional<Category> category=categoryRepository.findByDescription("American");
    Optional<UnitOfMeasure> unitOfMeasure=unitOfMeasureRepository.findByDescription("Tea Spoon");
        return "index";

}
}
