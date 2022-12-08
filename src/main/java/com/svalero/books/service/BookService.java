package com.svalero.books.service;

import com.svalero.books.domain.Book;
import com.svalero.books.exception.BookNotFoundException;

import java.util.List;
import java.util.Set;

//logica de la api. Llaman a la BBDD
public interface BookService {

    List<Book> findAll();
    Book findById(long id) throws BookNotFoundException;
    Book addBook(Book book);
    void deleteBook(long id) throws BookNotFoundException;
    Book modifyBook(long id, Book newBook) throws BookNotFoundException;
}
