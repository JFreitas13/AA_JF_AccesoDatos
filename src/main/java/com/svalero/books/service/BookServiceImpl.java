package com.svalero.books.service;

import com.svalero.books.domain.Book;
import com.svalero.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//implemento la interface. Capa de la logica
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository; //conexion a BBDD y asi tiene acceso a todos los metodos

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll(); //pido que me devuelva este metodo del repository
    }

    @Override
    public Book findById(long id) {
        return bookRepository.findById(id);
    }

}
