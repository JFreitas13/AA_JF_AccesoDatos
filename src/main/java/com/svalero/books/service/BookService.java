package com.svalero.books.service;

import com.svalero.books.domain.Book;
import com.svalero.books.exception.BookNotFoundException;
import com.svalero.books.exception.PublisherNotFoundException;
import com.svalero.books.exception.WriterNotFoundException;

import java.util.List;

//logica de la api. Llaman a la BBDD
public interface BookService {

    Book addBook(Book book, long publisherId, long writerId) throws PublisherNotFoundException, WriterNotFoundException;
    void deleteBook(long id) throws BookNotFoundException;
    Book modifyBook(long id, long publisherId, long writerId, Book newBook) throws BookNotFoundException, PublisherNotFoundException, WriterNotFoundException;
    List<Book> findAll();
    Book findById(long id) throws BookNotFoundException;
}
