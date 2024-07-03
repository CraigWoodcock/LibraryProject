package com.sparta.cw.libraryproject.Exceptions;

public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException (String fullName) {
        super("could not find Author: "+ fullName);
    }
}
