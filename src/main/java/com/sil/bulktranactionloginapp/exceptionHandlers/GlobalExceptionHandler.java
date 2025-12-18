//package com.sil.bulktranactionloginapp.exceptionHandlers;
//
//import com.sil.bulktranactionloginapp.Response.ErrorResponse;
//import com.sil.bulktranactionloginapp.annotations.RestControllerIdentifier;
//import com.sil.bulktranactionloginapp.exceptions.AccessDenide;
//import com.sil.bulktranactionloginapp.exceptions.MathExeption;
//import com.sil.bulktranactionloginapp.exceptions.PageNotFoundException;
//import com.sil.bulktranactionloginapp.interfaces.RestControllerIdenfierInterface;
//import jakarta.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.webmvc.error.ErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.context.request.WebRequest;
//
//
//import java.time.Instant;
//import java.util.Locale;
//import java.util.Map;
//
//import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.*;

//@RestControllerAdvice(annotations = RestControllerIdentifier.class)
//@RestControllerAdvice(assignableTypes = RestControllerIdenfierInterface.class)
//@RestControllerAdvice(basePackages = "com.sil.bulktranactionloginapp.controlles.rest")
//public class GlobalExceptionHandler {
//
//    @Autowired
//   private ErrorAttributes errorAttributes;
//
//   @ResponseBody
//   @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(ResourceNotFountException.class)
//    public ErrorResponse resourceNotFound(ResourceNotFountException ex)
//    {
//        return new ErrorResponse(HttpStatus.NOT_FOUND.value(),
//                HttpStatus.NOT_FOUND.toString(),
//                ex.getMessage()
//        );
//    }
//
//
//
//
//
//
//
//
//    @ResponseBody
//    @ExceptionHandler(MathExeption.class)
//    public ResponseEntity<?>mathExceptionHandler(Exception ex)
//    {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
//                Map.of("timestamp", Instant.now(),
//                        "status",HttpStatus.INTERNAL_SERVER_ERROR,
//                        "message",ex.getMessage(),
//                        "error",MathExeption.class.getSimpleName()
//
//                ) );
//
//
//
//    }
//
//
//
//    @ResponseBody
//    @ExceptionHandler(AccessDenide.class)
//    public ResponseEntity<?>accessDenideExceptionHandler(HttpServletRequest request, Exception ex)
//    {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
//                Map.of("timestamp", Instant.now(),
//                        "status",HttpStatus.FORBIDDEN,
//                        "message",ex.getMessage(),
//                        "error",AccessDenide.class.getSimpleName(),
//                        "path","while try to access url[%s]".formatted(request.getRequestURI())
//
//                ) );
//
//
//
//    }
//
//
//
//    @ResponseBody
//    @ExceptionHandler(PageNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String pageNotFoundExceptionHandler(
//            PageNotFoundException ex,
//            Model model) {
//
//        model.addAttribute("error", ex.getMessage());
//        return "page_not_found_error";
//    }
//
//
//
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Throwable.class)
//    public String errorHandler(Throwable ex)
//    {

//
//        WebRequest webRequest = new ServletWebRequest(request);
//
//        Map<String,Object> map = errorAttributes.getErrorAttributes(webRequest,
//                ErrorAttributeOptions.of(
//                        MESSAGE,STACK_TRACE,PATH,STATUS,ERROR
//                ));
//   model.addAttribute(map);
//        map.forEach(model::addAttribute);
//        model.addAttribute("error",ex.getMessage());
//        return "exception is :"+ex.getMessage();
//    }
//}
