package com.sil.bulktranactionloginapp.exceptionHandlers;

import com.sil.bulktranactionloginapp.annotations.MVCControllerIdentifier;
import com.sil.bulktranactionloginapp.exceptions.AccessDenide;
import com.sil.bulktranactionloginapp.services.BulkErrorLogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.webmvc.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;

@ControllerAdvice(annotations = MVCControllerIdentifier.class)
public class GlobalMVCExceptionHandler {
    private final BulkErrorLogService logService;

    public GlobalMVCExceptionHandler(BulkErrorLogService logService) {
        this.logService = logService;
    }

    @Autowired
    private ErrorAttributes errorAttributes;

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFountException.class)
    public Object resourceNotFound(HttpServletRequest request,
                                   ResourceNotFountException ex, Model model)
    {
        logService.logErrorAsync(  ex,
                HttpStatus.NOT_FOUND,
                request.getRequestURI(),
                ResourceNotFountException.class.getSimpleName());

            model.addAttribute("error",
                    ResourceNotFountException.class.getSimpleName());
            model.addAttribute("message",ex.getMessage());

            return "resource_not_found";

    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public String errorHandler(HttpServletRequest request,Throwable ex,Model model)
    {

        logService.logErrorAsync(  ex,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request.getRequestURI(),
                ex.getClass().getSimpleName());
        model.addAttribute("status", 500);
        model.addAttribute("error", "Internal Server Error");
        model.addAttribute("message", ex.getMessage());


//        model.addAttribute("path", request.getRequestURI());
        return "all_type_error";
    }



    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDenide.class)
    public Object accessDenideError(HttpServletRequest request,
                                    AccessDenide ex, Model model)
    {
        logService.logErrorAsync(  ex,
                HttpStatus.FORBIDDEN,
                request.getRequestURI(),
                AccessDenide.class.getSimpleName());

        model.addAttribute("error",
                ResourceNotFountException.class.getSimpleName());
        model.addAttribute("message",ex.getMessage());

        return "resource_not_found";

    }

}
