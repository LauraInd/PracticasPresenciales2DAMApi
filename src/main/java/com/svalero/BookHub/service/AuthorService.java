package com.svalero.BookHub.service;


import com.svalero.BookHub.repository.AuthorRepository;
import com.svalero.BookHub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

}
