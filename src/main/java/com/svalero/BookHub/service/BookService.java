package com.svalero.BookHub.service;

import com.svalero.BookHub.domain.Author;
import com.svalero.BookHub.domain.Book;
import com.svalero.BookHub.domain.dto.BookInDTO;
import com.svalero.BookHub.domain.dto.BookOutDTO;
import com.svalero.BookHub.exception.AuthorNotFoundException;
import com.svalero.BookHub.exception.BookNotFoundException;
import com.svalero.BookHub.repository.AuthorRepository;
import com.svalero.BookHub.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //para obtener todas los libros
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    //Para buscar por titulo del libro
    public List<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    //Para guardar un libro
    public Book saveBook(Book book){
       return bookRepository.save(book);
    }

    //Para eliminar un libro por id
    public void deleteBook(int bookId) throws BookNotFoundException {
        if (!bookRepository.existsById(bookId)) {
            throw new BookNotFoundException("Book not found by id: " + bookId);
        }
        bookRepository.deleteById(bookId);
    }

    //para buscar libro por id
    public Book getBookById(int bookId) throws BookNotFoundException{
        return bookRepository.findById(bookId).orElseThrow(()
                -> new BookNotFoundException("Book not found with id: " + bookId));

    }

    //para actualizar libro por id
    public Book updateBook(int id, Book bookDetails) throws BookNotFoundException {
        Book existingBook = bookRepository.findById(id).orElseThrow(() ->new BookNotFoundException("Book not found with id: " + id));

        //Actualizar los campos de la categoria existente con los nuevos valores
        existingBook.setTitle(bookDetails.getTitle());
        existingBook.setAuthor(bookDetails.getAuthor());
        existingBook.setPublisher(bookDetails.getPublisher());

        return bookRepository.save(existingBook);

    }


}
