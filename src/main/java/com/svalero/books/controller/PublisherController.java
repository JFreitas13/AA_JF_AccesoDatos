package com.svalero.books.controller;

import com.svalero.books.domain.Publisher;
import com.svalero.books.exception.PublisherNotFoundException;
import com.svalero.books.exception.ErrorMessage;
import com.svalero.books.exception.PublisherNotFoundException;
import com.svalero.books.service.PublisherService;
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


@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    private final Logger logger = LoggerFactory.getLogger(PublisherController.class);

    //añadir editorial
    @PostMapping("/publishers")
    public ResponseEntity<Publisher> addPublisher(@Valid @RequestBody Publisher publisher) {
        logger.debug("begin addPublisher");
        Publisher newPublisher = publisherService.addPublisher(publisher);
        logger.debug("end addPublisher");
        return ResponseEntity.status(HttpStatus.CREATED).body(newPublisher);
    }

    //borrar editorial
    @DeleteMapping("/publishers/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable long id) throws PublisherNotFoundException {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }

    //modificar editorial
    @PutMapping("/publishers/{id}")
    public ResponseEntity<Publisher> modifyPublisher(@PathVariable long id, @RequestBody Publisher publisher) throws PublisherNotFoundException {
        logger.debug("begin modifyPublisher");
        Publisher modifiedPublisher = publisherService.modifyPublisher(id, publisher);
        logger.debug("end modifyPublisher");
        return ResponseEntity.status(HttpStatus.OK).body(modifiedPublisher);
    }

    //buscar todas las editoriales
    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> getPublishers() {
        return ResponseEntity.ok(publisherService.findAll());
    }

    //buscar editorial por id
    @GetMapping("/publishers/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable long id) throws PublisherNotFoundException {
        logger.debug("begin getPublisher");
        Publisher publisher = publisherService.findByid(id);
        logger.debug("end getPublisher");
        return ResponseEntity.ok(publisher);
    }

    //Excepción 404: Book not found
    @ExceptionHandler(PublisherNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlePublisherNotFoundException(PublisherNotFoundException pnfe) {
        logger.error((pnfe.getMessage()), pnfe); //traza de log
        ErrorMessage errorMessage = new ErrorMessage(404, pnfe.getMessage());
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
