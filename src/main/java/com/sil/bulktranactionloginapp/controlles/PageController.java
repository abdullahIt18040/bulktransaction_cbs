package com.sil.bulktranactionloginapp.controlles;

import com.sil.bulktranactionloginapp.exceptions.PageNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
   @GetMapping("/home")
    public String home()
    {
        if(1==1)
        {
            throw new PageNotFoundException("home page can not found home page");
        }
        return "index";
    }
    @GetMapping("/about")
    public String about()
    {
        if(1==1)
            throw new RuntimeException("something went wrong");
        return "all_type_error";
    }
}
