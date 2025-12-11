package com.sil.bulktranactionloginapp.controlles;

import com.sil.bulktranactionloginapp.exceptions.AccessDenide;
import com.sil.bulktranactionloginapp.exceptions.MathExeption;
import org.springframework.boot.webmvc.autoconfigure.error.BasicErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
//    BasicErrorController
    @ResponseBody
    @RequestMapping("/calculate")
    public int calculate(@RequestParam("a") int a,@RequestParam("b")  int b)
    {
        if(b==0)
        {
            throw new MathExeption("a cant be 00");
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


}
