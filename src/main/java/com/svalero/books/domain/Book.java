package com.svalero.books.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Data //genera getters y setters automaticamente
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "El campo no puede estar en blanco")
    @NotNull(message = "El campo no puede estar vacío")
    private String name;

    @Column(length = 4)
    @NotBlank(message = "El campo no puede estar en blanco")
    @NotNull(message = "El campo no puede estar vacío")
    @DateTimeFormat(pattern = "yyyy")
    private String yearEdition;

    @Column
    private String ageRecommended;

    @Column
    @Min(value = 0)
    private int pagesNumber;

    @Column
    private String description;

    @Column
    @NotBlank(message = "El campo no puede estar en blanco")
    @NotNull(message = "El campo no puede estar vacío")
    private boolean ebook;

   @ManyToMany
    @JoinTable(name = "stocks",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "bookstore_id"))
    private List<Bookstore> bookstores;

    @ManyToMany
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "collection",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private List<Writer> writers;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
