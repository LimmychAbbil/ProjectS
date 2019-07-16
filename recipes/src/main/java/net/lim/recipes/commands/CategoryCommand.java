package net.lim.recipes.commands;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.lim.recipes.model.Category;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {
    private Long id;
    private String categoryName;

    public Category convert() {
        Category category = new Category();
        category.setId(this.id);
        category.setCategoryName(categoryName);

        return category;
    }
}
