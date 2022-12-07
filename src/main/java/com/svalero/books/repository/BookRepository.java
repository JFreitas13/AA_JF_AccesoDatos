package com.svalero.books.repository;

import com.svalero.books.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Set<Book> findAll(); //listado de todos los libros
    Book findById(long id); // buscar por id
}
