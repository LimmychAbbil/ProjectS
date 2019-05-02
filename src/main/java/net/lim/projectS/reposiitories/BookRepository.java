package net.lim.projectS.reposiitories;

import net.lim.projectS.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
