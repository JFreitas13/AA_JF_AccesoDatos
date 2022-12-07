package com.svalero.books.controller;

import com.svalero.books.domain.Book;
import com.svalero.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//logica de la api al exterior. Capa visible
@RestController
public class BookController {

    @Autowired
    BookService bookService; //no me puedo conectar directamente con la BBDD. Me conecto al Service que llama al Repository que llama a la BBDD
    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.findAll(); //me devuelve desde el service
    }
}
