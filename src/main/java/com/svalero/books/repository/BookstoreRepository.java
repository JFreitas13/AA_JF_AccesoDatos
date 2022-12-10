package com.svalero.books.repository;

import com.svalero.books.domain.Bookstore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookstoreRepository extends CrudRepository<Bookstore, Long> {

   List<Bookstore> findAll(); //Buscar todas las librerias
}
