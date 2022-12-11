package com.svalero.books.service;

import com.svalero.books.domain.Writer;
import com.svalero.books.exception.WriterNotFoundException;

import java.util.List;

public interface WriterService {

    Writer addWriter(Writer writer);
    void deleteWriter(long id) throws WriterNotFoundException;
    Writer modifyWriter(long id, Writer writer) throws WriterNotFoundException;
    List<Writer> findAll();
    Writer findById(long id) throws WriterNotFoundException;

}
