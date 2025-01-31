package com.svalero.BookHub.service;


import com.svalero.BookHub.domain.Author;
import com.svalero.BookHub.exception.AuthorNotFoundException;
import com.svalero.BookHub.repository.AuthorRepository;
import com.svalero.BookHub.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // Obtener todos los autores
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Buscar autores por nombre
    public List<Author> getAuthorsByName(String name) {
        return authorRepository.findByAuthorName(name);
    }

    // Buscar autores por fecha de nacimiento
    public List<Author> getAuthorsByBirthdayDate(LocalDate date) {
        return authorRepository.findByAuthorDate(date);
    }


    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    // Eliminar un autor por ID
    public void deleteAuthor(Long id) throws AuthorNotFoundException {
        if (!authorRepository.existsById(id)) {
            throw new AuthorNotFoundException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }
}
