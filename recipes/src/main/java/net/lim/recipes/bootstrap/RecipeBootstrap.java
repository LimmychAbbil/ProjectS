package net.lim.recipes.bootstrap;

import net.lim.recipes.model.Category;
import net.lim.recipes.model.Difficulty;
import net.lim.recipes.model.Ingridient;
import net.lim.recipes.model.Recipe;
import net.lim.recipes.model.UnitOfMeasure;
import net.lim.recipes.repositories.CategoryRepository;
import net.lim.recipes.repositories.RecipeRepository;
import net.lim.recipes.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private RecipeRepository recipeRepository;

    private CategoryRepository categoryRepository;

    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        initData();
    }

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    private void initData() {
        Category defaultCategory = categoryRepository.findById(1L).orElse(new Category());
        UnitOfMeasure defaultUOM = unitOfMeasureRepository.findById("spoon").get();
        Ingridient defaultIngridient = new Ingridient("default", new BigDecimal(5), defaultUOM);

        Recipe recipe = new Recipe();
        recipe.setCategories(Collections.singleton(defaultCategory));
        recipe.setCookTime(150);
        recipe.setDescriptions("ABC");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setPrepTime(20);
        recipe.setServings(5);
        recipe.setIngridients(Collections.singleton(defaultIngridient));

        recipeRepository.save(recipe);
    }
}
