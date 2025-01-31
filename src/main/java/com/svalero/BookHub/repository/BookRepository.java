package com.svalero.BookHub.repository;

import com.svalero.BookHub.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    List<Book> findByTitleAndAuthor(String title, String author);
    List<Book> findByTitleOrAuthor(String title, String author);

}
