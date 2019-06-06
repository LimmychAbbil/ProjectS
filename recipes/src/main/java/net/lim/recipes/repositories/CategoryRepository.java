package net.lim.recipes.repositories;

import net.lim.recipes.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
