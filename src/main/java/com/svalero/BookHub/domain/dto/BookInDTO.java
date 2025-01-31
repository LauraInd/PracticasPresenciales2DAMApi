package com.svalero.BookHub.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInDTO {
    private String title;
    private String genre;
    private String publisher;
    private LocalDate publicationDate;
}
