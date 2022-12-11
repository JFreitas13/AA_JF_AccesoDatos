package com.svalero.books.repository;

import com.svalero.books.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {

    List<Publisher> findAll(); //listado de todos las editoriales
}
