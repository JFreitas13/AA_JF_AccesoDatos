package com.svalero.books.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data //genera getters y setters automaticamente
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "book")
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
   // @NotBlank(message = "El campo no puede estar en blanco")
    //@NotNull(message = "El campo no puede estar vacío")
    private String description;

    @Column
    @NotNull
    private boolean ebook;

   /*@ManyToMany
    @JoinTable(name = "stock",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "bookstore_id"))
    private List<Bookstore> bookstores;*/
}
