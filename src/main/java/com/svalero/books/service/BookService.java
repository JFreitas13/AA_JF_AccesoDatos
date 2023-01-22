package com.svalero.books.service;

import com.svalero.books.domain.Book;
import com.svalero.books.exception.BookNotFoundException;
import com.svalero.books.exception.PublisherNotFoundException;

import java.util.List;

//logica de la api. Llaman a la BBDD
public interface BookService {

    Book addBook(Book book, long publisherId) throws PublisherNotFoundException;
    void deleteBook(long id) throws BookNotFoundException;
    Book modifyBook(long id, Book newBook) throws BookNotFoundException;
    List<Book> findAll();
    Book findById(long id) throws BookNotFoundException;
}
