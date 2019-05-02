package net.lim.projectS.bootstrap;

import net.lim.projectS.model.Author;
import net.lim.projectS.model.Book;
import net.lim.projectS.model.Publisher;
import net.lim.projectS.reposiitories.AuthorRepository;
import net.lim.projectS.reposiitories.BookRepository;
import net.lim.projectS.reposiitories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent applicationEvent) {
        initData();
    }

    private void initData() {
        Author tolkien = new Author("John", "Tolkien");
        Publisher publisher = new Publisher("somePublisher", "???");
        Book lordOfTheRings = new Book("Lord of the rings", "111", publisher);
        tolkien.getBooks().add(lordOfTheRings);
        lordOfTheRings.getAuthors().add(tolkien);

        publisherRepository.save(publisher);
        authorRepository.save(tolkien);
        bookRepository.save(lordOfTheRings);
    }
}
