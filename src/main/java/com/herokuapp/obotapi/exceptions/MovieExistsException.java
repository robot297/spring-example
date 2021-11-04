package com.herokuapp.obotapi.exceptions;

public class MovieExistsException extends Exception {

    public MovieExistsException(String message){
        super(message);
    }
}
