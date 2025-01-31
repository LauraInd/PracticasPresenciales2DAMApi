package com.svalero.BookHub.exception;

public class AuthorNotFoundException extends Exception {

    public AuthorNotFoundException() { super("The Author does not exist"); }

    public AuthorNotFoundException(String message) { super(message); }


}
