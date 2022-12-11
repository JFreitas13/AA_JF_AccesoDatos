package com.svalero.books.controller;

import com.svalero.books.domain.Writer;
import com.svalero.books.exception.ErrorMessage;
import com.svalero.books.exception.WriterNotFoundException;
import com.svalero.books.service.WriterService;
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
public class WriterController {

    @Autowired
    WriterService writerService;

    private final Logger logger = LoggerFactory.getLogger(WriterController.class);

    @PostMapping("/writers")
    public ResponseEntity<Writer> addWriter(@Valid @RequestBody Writer writer) {
        logger.debug("begin addWriter");
        Writer newWriter = writerService.addWriter(writer);
        logger.debug("end addWriter");
        return ResponseEntity.status(HttpStatus.CREATED).body(newWriter);
    }

    @DeleteMapping("/writers/{id}")
    public ResponseEntity<Void> deleteWriter(@PathVariable long id) throws WriterNotFoundException {
        writerService.deleteWriter(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("writers/{id}")
    public ResponseEntity<Writer> modifyWriter(@PathVariable long id, Writer writer) throws WriterNotFoundException {
        logger.debug("begin modifyWriter");
        Writer modifiedWriter = writerService.modifyWriter(id, writer);
        logger.debug("end modifyWriter");
        return ResponseEntity.status(HttpStatus.OK).body(modifiedWriter);
    }

    @GetMapping("/writers")
    public ResponseEntity<List<Writer>> getWriters() {
        return ResponseEntity.ok(writerService.findAll());
    }

    @GetMapping("writers/id")
    public ResponseEntity<Writer> getWriter(@PathVariable long id) throws WriterNotFoundException {
        logger.debug("begin getWriter");
        Writer writer = writerService.findById(id);
        logger.debug("end getWriter");
        return ResponseEntity.ok(writer);
    }

    //Excepción 404: Book not found
    @ExceptionHandler(WriterNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleWriterNotFoundException(WriterNotFoundException wnfe) {
        logger.error((wnfe.getMessage()), wnfe); //traza de log
        ErrorMessage errorMessage = new ErrorMessage(404, wnfe.getMessage());
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
