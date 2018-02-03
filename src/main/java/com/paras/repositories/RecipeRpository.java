package com.paras.repositories;

import com.paras.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRpository extends CrudRepository<Recipe,Long> {

}
