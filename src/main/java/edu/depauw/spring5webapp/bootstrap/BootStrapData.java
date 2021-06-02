package edu.depauw.spring5webapp.bootstrap;

import edu.depauw.spring5webapp.model.Author;
import edu.depauw.spring5webapp.model.Book;
import edu.depauw.spring5webapp.model.Publisher;
import edu.depauw.spring5webapp.repositories.AuthorRepository;
import edu.depauw.spring5webapp.repositories.BookRepository;
import edu.depauw.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher springer = new Publisher("Springer Verlag", "313 South Locust Street",
                "Greencastle", "IN", "46135");

        publisherRepository.save(springer);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(springer);
        springer.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "325421513");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(springer);
        springer.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(springer);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher number of books: " + springer.getBooks().size());
    }
}
