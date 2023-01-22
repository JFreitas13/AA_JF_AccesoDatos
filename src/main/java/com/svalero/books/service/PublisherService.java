package com.svalero.books.service;

import com.svalero.books.domain.Publisher;
import com.svalero.books.exception.PublisherNotFoundException;

import java.util.List;

public interface PublisherService {

    Publisher addPublisher (Publisher publisher);
    void deletePublisher(long id) throws PublisherNotFoundException;
    Publisher modifyPublisher(long id, Publisher publisher) throws PublisherNotFoundException;
    List<Publisher> findAll();
    Publisher findById(long id) throws PublisherNotFoundException;
}

