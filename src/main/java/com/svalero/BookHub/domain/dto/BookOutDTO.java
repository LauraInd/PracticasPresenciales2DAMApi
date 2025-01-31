package com.svalero.BookHub.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookOutDTO {
    private long id;
    private String title;
    private String genre;
    private String publisher;
    private LocalDate publicationDate;
    private long authorId;
}
