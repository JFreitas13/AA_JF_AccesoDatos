package com.svalero.books.service;

import com.svalero.books.domain.Bookstore;
import com.svalero.books.exception.BookstoreNotFoundException;

import java.util.List;

public interface BookstoreService {

    List<Bookstore> findAll();
    Bookstore findById(long id) throws BookstoreNotFoundException;
    Bookstore addBookstore(Bookstore bookstore);
    void deleteBookstore(long id) throws BookstoreNotFoundException;
    Bookstore modifyBookstore(long id, Bookstore bookstore) throws  BookstoreNotFoundException;
}
