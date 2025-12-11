package com.sil.bulktranactionloginapp.controlles;


import com.sil.bulktranactionloginapp.dto.LoginRequest;
import com.sil.bulktranactionloginapp.entities.User;
import com.sil.bulktranactionloginapp.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequiredArgsConstructor
public class UserController {
//HttpStatus

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        if (!model.containsAttribute("loginRequest")) {
            model.addAttribute("loginRequest", new LoginRequest());
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
           @ModelAttribute("loginRequest") LoginRequest loginRequest,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {

        if (result.hasErrors()) {
            // Return validation errors back to login page
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginRequest", result);
            redirectAttributes.addFlashAttribute("loginRequest", loginRequest);
            return "redirect:/login2";
        }

        User user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());

        if (user == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid email or password!");
            return "redirect:/login2";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Login Successful!");
        return "redirect:/login2"; // or dashboard
    }
}
