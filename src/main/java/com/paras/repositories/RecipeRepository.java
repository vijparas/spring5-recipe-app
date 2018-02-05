package com.paras.repositories;

import com.paras.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RecipeRepository extends CrudRepository<Recipe,Long> {

}
