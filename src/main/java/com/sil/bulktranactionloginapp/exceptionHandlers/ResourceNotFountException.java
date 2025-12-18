package com.sil.bulktranactionloginapp.exceptionHandlers;

public class ResourceNotFountException extends RuntimeException{
    public ResourceNotFountException(String message) {
        super(message);
    }
}
