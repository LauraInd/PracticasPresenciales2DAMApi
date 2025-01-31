package com.svalero.BookHub.service;

import com.svalero.BookHub.domain.Author;
import com.svalero.BookHub.domain.Book;
import com.svalero.BookHub.domain.dto.BookInDTO;
import com.svalero.BookHub.domain.dto.BookOutDTO;
import com.svalero.BookHub.exception.AuthorNotFoundException;
import com.svalero.BookHub.repository.AuthorRepository;
import com.svalero.BookHub.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
  ;

    public Book createBook(Book book, long authorId) throws AuthorNotFoundException {
        Author author = authorRepository.findById(authorId).orElseThrow(AuthorNotFoundException::new);
        book.setAuthor(author);
        return bookRepository.save(book);

    }

}
