package com.svalero.books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "users")
public class User {

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
    private String email;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String password;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String phoneNumber;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String city;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String zipCode;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String rol;

    @ManyToMany(mappedBy = "users")
    private List<Book> books;

}
