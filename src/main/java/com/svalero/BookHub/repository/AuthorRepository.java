package com.svalero.BookHub.repository;

import com.svalero.BookHub.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface AuthorRepository extends CrudRepository<Author, Long> {
    // Método para obtener todos los autores
    List<Author> findAll();




}
