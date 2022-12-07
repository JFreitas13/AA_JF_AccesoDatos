package com.svalero.books.repository;

import com.svalero.books.domain.Writer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriterRpository extends CrudRepository<Writer, Long> {
}
