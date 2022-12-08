package com.svalero.books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "bookstores")
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "El campo no puede estar en blanco")
    @NotNull(message = "El campo no puede estar vacío")
    private String name;

    @Column
    private String city;

    @Column(name = "zip_code", length = 5)
    @NotBlank(message = "El campo no puede estar en blanco")
    @NotNull(message = "El campo no puede estar vacío")
    private String zipCode;

    @Column
    @NotBlank(message = "El campo no puede estar en blanco")
    @NotNull(message = "El campo no puede estar vacío")
    @Pattern(regexp = "[6][0-9]{8}") //para que el telefono movil empiece por 6 y tenga 9 digitos.
    private String phoneNumber;

    @Column
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime open;

    @Column
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime close;

    @ManyToMany(mappedBy = "bookstores" )
    private List<Book> books;
}
