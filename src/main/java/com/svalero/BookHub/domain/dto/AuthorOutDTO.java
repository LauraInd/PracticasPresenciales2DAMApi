package com.svalero.BookHub.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorOutDTO {
    private long id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private boolean active;

}
