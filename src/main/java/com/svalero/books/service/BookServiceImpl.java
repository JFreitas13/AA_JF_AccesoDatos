package com.svalero.books.service;

import com.svalero.books.domain.Book;
import com.svalero.books.exception.BookNotFoundException;
import com.svalero.books.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//implemento la interface. Capa de la logica
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository; //conexion a BBDD y asi tiene acceso a todos los metodos

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book); //meto save es "gratis" para guardar. Le pasas el objeto y el metodo save lo guarda en la BBDD
    }

    @Override
    public void deleteBook(long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.delete(book);
    }

    @Override
    public Book modifyBook(long id, Book newBook) throws BookNotFoundException {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        //modelMapper.map(newBook, existingBook);
        existingBook.setName(newBook.getName());
        existingBook.setYearEdition(newBook.getYearEdition());
        existingBook.setAgeRecommended(newBook.getAgeRecommended());
        existingBook.setPagesNumber(newBook.getPagesNumber());
        existingBook.setDescription(newBook.getDescription());
        existingBook.setEbook(newBook.isEbook());

        return bookRepository.save(existingBook);
    }
}
    /*existingBook.setName(newBook.getName());
            existingBook.setYearEdition(newBook.getYearEdition());
            existingBook.setAgeRecommended(newBook.getAgeRecommended());
            existingBook.setPagesNumber(newBook.getPagesNumber());
            existingBook.setDescription(newBook.getDescription());
            existingBook.setEbook(newBook.isEbook());*/