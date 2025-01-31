package com.svalero.BookHub.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorInDTO {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private boolean active;

}
