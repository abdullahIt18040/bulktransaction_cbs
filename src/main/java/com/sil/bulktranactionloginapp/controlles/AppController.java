package com.sil.bulktranactionloginapp.controlles;

import com.sil.bulktranactionloginapp.annotations.MVCControllerIdentifier;
import com.sil.bulktranactionloginapp.annotations.RestControllerIdentifier;
import com.sil.bulktranactionloginapp.exceptions.AccessDenide;
import com.sil.bulktranactionloginapp.exceptions.MathExeption;
import org.springframework.boot.webmvc.autoconfigure.error.BasicErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestControllerIdentifier
@RestController
public class AppController {
// BasicErrorController
//    @ResponseBody
    @RequestMapping("/calculate")
    public int calculate(@RequestParam("a") int a,@RequestParam("b")  int b)
    {
        if(b==0)
        {
            throw new MathExeption("a cant be 00");
        }
        if(a==0)
        {
            throw new RuntimeException("a cant be 0");
        }
        return a/b;
    }
    @GetMapping("/hellow")
    public void dispaly()
    {
       if (1==1)
       {
           throw new RuntimeException("Ex----------------");
       }
    }
    @GetMapping("/info")
    public String info()
    {
        if(1==1)
        {
         throw new AccessDenide("you are not allowed to access this resource") ;

        }
        return "info";
    }
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Throwable.class)
//    public String errorHandler(Exception ex)
//    {
//        return "something went wrong"+ex.getMessage();
//    }


}
