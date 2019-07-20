package net.lim.recipes.services;

import net.lim.recipes.commands.CategoryCommand;
import net.lim.recipes.model.Category;
import net.lim.recipes.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class DefaultCategoryService implements CategoryService {
    private CategoryRepository categoryRepository;

    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getAllCategories() {
        Set<Category> categories = new LinkedHashSet<>();
        categoryRepository.findAll().forEach(category -> categories.add(category));
        return categories;
    }

    @Override
    public CategoryCommand addOrUpdateCategory(CategoryCommand command) {
        categoryRepository.save(command.convert());
        return command;
    }

    @Override
    public boolean deleteCategory(Category category) {
        if (category.getRecipes().size() == 0) {
            categoryRepository.delete(category);
            return true;
        }
        return false;
    }
}
