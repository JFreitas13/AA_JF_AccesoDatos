package com.svalero.books.exception;

public class CopyNotFoundException extends Exception{

    public CopyNotFoundException() {
        super("Order not found");
    }

    public CopyNotFoundException(String message) {
        super(message);
    }
}
