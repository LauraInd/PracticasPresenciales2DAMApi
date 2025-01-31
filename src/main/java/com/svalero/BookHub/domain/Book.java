package com.svalero.BookHub.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Book")
@Table(name = "books")

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private String publisher;
    @Column
    private LocalDate publicationDate;
    @Column
    private boolean active;

@ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


}
