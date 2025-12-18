//package com.sil.bulktranactionloginapp.exceptionHandlers;
//
//import com.sil.bulktranactionloginapp.Response.ErrorResponse;
//import com.sil.bulktranactionloginapp.annotations.MVCControllerIdentifier;
//import com.sil.bulktranactionloginapp.exceptionHandlers.ResourceNotFountException;
//import com.sil.bulktranactionloginapp.interfaces.MvcControllerIdenfierInterface;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice(annotations = MVCControllerIdentifier.class)
//@ControllerAdvice(assignableTypes = MvcControllerIdenfierInterface.class)
//@ControllerAdvice(basePackages = "com.sil.bulktranactionloginapp.controlles.mvc")
//@ControllerAdvice()
//public class GloblMvcExceptionHandler {
//
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(ResourceNotFountException.class)
//    public Object resourceNotFound(HttpServletRequest request,
//                                   ResourceNotFountException ex, Model model)
//    {
//
//        var accepts =  request.getHeader(HttpHeaders.ACCEPT);
//        if(accepts.contains(MediaType.TEXT_HTML_VALUE))
//        {
//            model.addAttribute("error",
//                    ResourceNotFountException.class.getSimpleName());
//            model.addAttribute("message",ex.getMessage());
//
//            return "resource_not_found";
//        }
//        var error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
//                HttpStatus.NOT_FOUND.toString(),
//                ex.getMessage()
//        );
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//
//
//    }
//}
