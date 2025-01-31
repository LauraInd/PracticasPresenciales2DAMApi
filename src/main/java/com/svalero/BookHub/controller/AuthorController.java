package com.svalero.BookHub.controller;

import com.svalero.BookHub.domain.Author;
import com.svalero.BookHub.exception.AuthorNotFoundException;
import com.svalero.BookHub.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // Obtener todos los autores
    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        logger.info("BEGIN getAllAuthors");
        List<Author> authors = authorService.getAllAuthors();
        logger.info("END getAllAuthors - Total authors fetched: {}", authors.size());
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    // Agregar un nuevo autor
    @PostMapping
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        logger.info("BEGIN addAuthor - Adding new author: {}", author.getName());
        Author newAuthor = authorService.saveAuthor(author);
        logger.info("END addAuthor - Author added with ID: {}", newAuthor.getId());
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    // Eliminar un autor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) throws AuthorNotFoundException {
        logger.info("BEGIN deleteAuthor - Deleting author with ID: {}", id);
        try {
            authorService.deleteAuthor(id);
            logger.info("END deleteAuthor - Author deleted with ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            logger.error("Error in deleteAuthor - Author not found with ID: {}", id, e);
            throw e;
        }
    }

    // Manejar excepciones de  un autor no encontrado
    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<String> handleAuthorNotFoundException(AuthorNotFoundException exception) {
        logger.error("Handling AuthorNotFoundException - {}", exception.getMessage(), exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
