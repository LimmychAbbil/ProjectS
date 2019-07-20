package net.lim.recipes.services;

import net.lim.recipes.commands.CategoryCommand;
import net.lim.recipes.model.Category;

import java.util.Set;

public interface CategoryService {

    Set<Category> getAllCategories();

    CategoryCommand addOrUpdateCategory(CategoryCommand command);

    boolean deleteCategory(Category category);
}
