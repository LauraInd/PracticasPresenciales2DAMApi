package com.svalero.BookHub.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Author")
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Date birthdate;
    @Column
    private Boolean active;


    @OneToMany(mappedBy = "author")
    @JsonBackReference(value = "authors_books")
    private List<Book> books;

}
