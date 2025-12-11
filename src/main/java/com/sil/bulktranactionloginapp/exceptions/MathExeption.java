package com.sil.bulktranactionloginapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MathExeption extends RuntimeException{
    public MathExeption(String msg) {
        super(msg);
    }
}
