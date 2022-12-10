package com.svalero.books.controller;

import com.svalero.books.domain.Book;
import com.svalero.books.exception.BookNotFoundException;
import com.svalero.books.exception.ErrorMessage;
import com.svalero.books.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//logica de la api al exterior. Capa visible
@RestController
public class BookController {

    @Autowired
    BookService bookService; //no me puedo conectar directamente con la BBDD. Me conecto al Service que llama al Repository que llama a la BBDD

    private final Logger logger = LoggerFactory.getLogger(BookController.class); //Creamos el objeto capaz de pintar las trazas en el log y lo asociamos a la clase que queremos controlar

    //añadir libro
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        logger.debug("begin addBook"); //Para indicar en el log que alguien ha llamado a esta parte
        Book newBook = bookService.addBook(book);
        logger.debug("end addBook"); //Para indicar en el log que termina la llamada anterior
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    //borrar libro
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id) throws BookNotFoundException {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    //modificar libro
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> modifyBook(@PathVariable long id, @RequestBody Book book) throws BookNotFoundException {
        logger.debug("begin modifyBook");
        Book modifiedBook = bookService.modifyBook(id, book);
        logger.debug("end modifyBook");
        return ResponseEntity.status(HttpStatus.OK).body(modifiedBook);
    }

    //buscar todos los libros
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.findAll()); //me devuelve desde el service
    }

    //buscar libro por id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable long id) throws BookNotFoundException {
        logger.debug("begin getBook"); //Para indicar en el log que alguien ha llamado a esta parte
        Book book = bookService.findById(id); //cojo el libro
        logger.debug("end getBook"); //Para indicar en el log que termina la llamada anterior
        return ResponseEntity.ok(book); //devuelvo la respuesta con el book
    }

    //Excepción 404: Book not found
    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBookNotFoundException(BookNotFoundException bnfe) {
        logger.error((bnfe.getMessage()), bnfe); //traza de log
        ErrorMessage errorMessage = new ErrorMessage(404, bnfe.getMessage());
        return new ResponseEntity(errorMessage, HttpStatus.NOT_FOUND);
    }

    //Excetion 400: Bad request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(MethodArgumentNotValidException manve) {
        logger.error((manve.getMessage()), manve); //traza de log
        Map<String, String> errors = new HashMap<>(); //Montamos un Map de errores
        manve.getBindingResult().getAllErrors().forEach(error -> { //para la exception manve recorremos todos los campos
                    String fieldName = ((FieldError) error).getField(); //Extraemos con getField el nombre del campo que no ha pasado la validación
                    String message = error.getDefaultMessage(); // y el mensaje asociado
                    errors.put(fieldName, message);
        });

        ErrorMessage errorMessage = new ErrorMessage(400, "Bad Request");
        return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
    }

    //cualquier exception. 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception e) {
        logger.error((e.getMessage()), e); //traza de log
        ErrorMessage errorMessage = new ErrorMessage(500, "Internal Server Error");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
