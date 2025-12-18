package com.sil.bulktranactionloginapp.exceptionHandlers;

import com.sil.bulktranactionloginapp.Response.ErrorResponse;
import com.sil.bulktranactionloginapp.annotations.RestControllerIdentifier;
import com.sil.bulktranactionloginapp.exceptions.MathExeption;
import com.sil.bulktranactionloginapp.services.BulkErrorLogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice(annotations = RestControllerIdentifier.class)
public class GlobalRestExceptionHandler {
    private final BulkErrorLogService logService;

    public GlobalRestExceptionHandler(BulkErrorLogService logService) {
        this.logService = logService;
    }
    @Autowired
   private ErrorAttributes errorAttributes;

   @ResponseBody
   @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFountException.class)
    public ErrorResponse resourceNotFound(HttpServletRequest request,ResourceNotFountException ex)
    {
        logService.logErrorAsync( ex,
                HttpStatus.NOT_FOUND,
                request.getRequestURI(),
                ex.getClass().getSimpleName());
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.toString(),
                ex.getMessage()
        );
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MathExeption.class)
    public ErrorResponse arithMaticsError(HttpServletRequest request,MathExeption ex)
    {
        logService.logErrorAsync( ex,
                HttpStatus.BAD_REQUEST,
                request.getRequestURI(),
                ex.getClass().getSimpleName());
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResponse errorHandler(HttpServletRequest request,Throwable ex)
    {
        logService.logErrorAsync(ex,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request.getRequestURI(),
                ex.getClass().getSimpleName());
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                ex.getMessage()
        );
    }


}
