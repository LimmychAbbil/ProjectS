package net.lim.projectS.reposiitories;

import net.lim.projectS.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
