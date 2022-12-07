package com.svalero.books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "writers")
public class Writer {

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
    private String description;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String age;

    @Column(name = "social_networks")
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String socialNetworks;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String reviews;

    @ManyToMany(mappedBy = "writers")
    private List<Book> books;
}
