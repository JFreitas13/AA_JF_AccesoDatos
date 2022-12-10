package com.svalero.books.service;

import com.svalero.books.domain.Bookstore;
import com.svalero.books.exception.BookstoreNotFoundException;
import com.svalero.books.repository.BookstoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService {

    @Autowired
    BookstoreRepository bookstoreRepository; //conexion a BBDD

    @Autowired
    private ModelMapper modelMapper;

    //buscar todas las librerias
    @Override
    public List<Bookstore> findAll() {
        return bookstoreRepository.findAll();
    }

    //buscar libreria por id
    @Override
    public Bookstore findById(long id) throws BookstoreNotFoundException {
        return bookstoreRepository.findById(id)
                .orElseThrow(BookstoreNotFoundException::new);
    }

    //añadir libreira
    @Override
    public Bookstore addBookstore(Bookstore bookstore) {
        return bookstoreRepository.save(bookstore);
    }

    @Override
    public void deleteBookstore(long id) throws BookstoreNotFoundException {
        Bookstore bookstore = bookstoreRepository.findById(id)
                .orElseThrow(BookstoreNotFoundException::new);
        bookstoreRepository.delete(bookstore);
    }

    //modificar libreria
    @Override
    public Bookstore modifyBookstore(long id, Bookstore newBookstore) throws BookstoreNotFoundException {
        Bookstore existingBookstore = bookstoreRepository.findById(id)
                .orElseThrow(BookstoreNotFoundException::new);
        newBookstore.setId(id);
        modelMapper.map(newBookstore, existingBookstore);

        return bookstoreRepository.save(existingBookstore);
    }

}
