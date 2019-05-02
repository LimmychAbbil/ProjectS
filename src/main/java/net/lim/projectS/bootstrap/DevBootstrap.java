package net.lim.projectS.bootstrap;

import net.lim.projectS.model.Author;
import net.lim.projectS.model.Book;
import net.lim.projectS.reposiitories.AuthorRepository;
import net.lim.projectS.reposiitories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        initData();
    }

    private void initData() {
        Author tolkien = new Author("John", "Tolkien");
        Book lordOfTheRings = new Book("Lord of the rings", "111", "???");
        tolkien.getBooks().add(lordOfTheRings);
        lordOfTheRings.getAuthors().add(tolkien);

        authorRepository.save(tolkien);
        bookRepository.save(lordOfTheRings);
    }
}
