package com.svalero.books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "bookstore")
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String name;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String city;

    @Column(name = "zip_code")
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String zipCode;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String phoneNumber;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private LocalTime open;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private LocalTime close;

    /* @ManyToMany(mappedBy = "bookstores" )
    private List<Book> books;*/
}
