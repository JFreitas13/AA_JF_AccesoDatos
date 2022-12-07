package com.svalero.books.service;

import com.svalero.books.domain.Book;

import java.util.Set;

//logica de la api. Llaman a la BBDD
public interface BookService {

    Set<Book> findAll();
    Book findById(long id);
}
