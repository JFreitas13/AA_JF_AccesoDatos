package com.svalero.books.repository;

import com.svalero.books.domain.Bookstore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookstoreRepository extends CrudRepository<Bookstore, Long> {
}
