package com.svalero.BookHub.controller;

import com.svalero.BookHub.domain.Book;
import com.svalero.BookHub.exception.BookNotFoundException;
import com.svalero.BookHub.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //Para obtener todos los libros
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        logger.info("BEGIN getAllBook");
        List<Book> books = bookService.getAllBooks();
        logger.info("END getAllBook - Total books fetched: {}", getAllBooks());
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //Para agregar un libro nuevo
    @PostMapping("/authors/{authorId}/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        logger.info("BEGIN createBook - Creating new book");
        Book newBook = bookService.saveBook(book);
        logger.info("END createBook - Book created with id {}", newBook.getId());
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    //para buscar libro por id
    @GetMapping("books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable int bookId) throws BookNotFoundException {
        logger.info("BEGIN getBook - Getting book with id {}", bookId);
        try{
            Book book = bookService.getBookById(bookId);
            logger.info("END getBook - Book with id {}", bookId);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in getBook - Book not found by id: {}",bookId, e);
            throw e;
        }

    }

    //para buscar libro por titulo
    @GetMapping("books/title")
    public ResponseEntity<List<Book>> getBookByTitle(@RequestParam String title) {
        logger.info("BEGIN getBookByTitle - Getting book with title {}", title);
        List<Book> books = bookService.getBookByTitle(title);
        logger.info("END getBookByTitle - Book with title {}", title);
        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    //para eliminar un libro por id
    @DeleteMapping("books/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable int bookId) throws BookNotFoundException {
        logger.info("BEGIN deleteBook - Deleting book with id {}", bookId);
        try{
            bookService.deleteBook(bookId);
            logger.info("END deleteBook - Book with id {}", bookId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in deleteBook - Book not found by id: {}",bookId, e);
            throw e;

        }
    }

    //para actualizar un libro por id
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable int bookId, @RequestBody Book bookDetails) throws BookNotFoundException {
        logger.info("BEGIN updateBook - Updating book with id {}", bookId);
        try {
            Book updatedBook = bookService.updateBook(bookId, bookDetails);
            logger.info("END updateBook - Book with id {}", updatedBook.getId());
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error in updateBook - Book not found by id: {}",bookId, e);
            throw e;
        }
    }



}
