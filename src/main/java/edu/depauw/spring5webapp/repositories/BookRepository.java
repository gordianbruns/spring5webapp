package edu.depauw.spring5webapp.repositories;

import edu.depauw.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
