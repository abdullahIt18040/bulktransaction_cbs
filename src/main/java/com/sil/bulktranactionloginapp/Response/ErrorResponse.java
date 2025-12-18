package com.sil.bulktranactionloginapp.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class ErrorResponse {

    private Date timestamp = new Date();
    private String message;
    private String status;
    private int statuscode;

    public ErrorResponse(int statuscode, String status, String message) {
        this.timestamp = new Date();
        this.statuscode = statuscode;
        this.status = status;
        this.message = message;
    }

}
