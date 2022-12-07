package com.svalero.books.service;

import com.svalero.books.domain.Book;

import java.util.List;

//logica de la api. Llaman a la BBDD
public interface BookService {

    List<Book> findAll();
    Book findById(long id);
}
