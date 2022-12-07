package com.svalero.books.service;

import com.svalero.books.domain.Book;
import com.svalero.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

//implemento la interface. Capa de la logica
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository; //conexion a BBDD y asi tiene acceso a todos los metodos

    @Override
    public Set<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id);
    }
}
