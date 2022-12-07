package com.svalero.books.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String name;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String yearEdition;

    @Column
    //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String ageRecommended;

    @Column
    //@Min(value = 0)
    private int pagesNumber;

    @Column
   //@NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String description;

    @Column
    @NotNull
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
