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

    // Obtener un autor por ID
    public Author getAuthorById(Long id) throws AuthorNotFoundException {
        return authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));
    }


    // Actualizar un autor por ID
    public Author updateAuthor(Long id, Author authorDetails) throws AuthorNotFoundException {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException("Author not found with id: " + id));

        // Actualizar los campos del evento existente con los nuevos valores
        existingAuthor.setName(authorDetails.getName());
        existingAuthor.setSurname(authorDetails.getSurname());
        existingAuthor.setBirthdate(authorDetails.getBirthdate());
        existingAuthor.setActive(authorDetails.getActive());

        return authorRepository.save(existingAuthor);
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
