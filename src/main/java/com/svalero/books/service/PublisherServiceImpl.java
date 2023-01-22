package com.svalero.books.service;

import com.svalero.books.domain.Publisher;
import com.svalero.books.exception.PublisherNotFoundException;
import com.svalero.books.repository.PublisherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void deletePublisher(long id) throws PublisherNotFoundException {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(PublisherNotFoundException::new);
        publisherRepository.delete(publisher);
    }

    @Override
    public Publisher modifyPublisher(long id, Publisher newPublisher) throws PublisherNotFoundException {
        Publisher existingPublisher = publisherRepository.findById(id)
                .orElseThrow(PublisherNotFoundException::new);
        newPublisher.setId(id);
        modelMapper.map(newPublisher, existingPublisher);
        return publisherRepository.save(existingPublisher);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @Override
    public Publisher findById(long id) throws PublisherNotFoundException {
        return publisherRepository.findById(id)
                .orElseThrow(PublisherNotFoundException::new);
    }


}
