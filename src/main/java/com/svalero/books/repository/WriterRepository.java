package com.svalero.books.repository;

import com.svalero.books.domain.Writer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WriterRepository extends CrudRepository<Writer, Long> {

    List<Writer> findAll();
}
