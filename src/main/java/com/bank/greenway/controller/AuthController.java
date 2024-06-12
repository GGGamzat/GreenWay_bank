package com.bank.greenway.controller;

import com.bank.greenway.entity.Account;
import com.bank.greenway.entity.Article;
import com.bank.greenway.entity.User;
import com.bank.greenway.repository.UserRepository;
import com.bank.greenway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class AuthController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/registration")
    public String showRegPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@RequestParam(required = true, defaultValue = "!@") String username,
                               @RequestParam(required = true, defaultValue = "!@") String firstname,
                               @RequestParam(required = true, defaultValue = "!@") String lastname,
                               @RequestParam(required = true, defaultValue = "!@") Integer age,
                               @RequestParam(required = true, defaultValue = "!@") String email,
                               @RequestParam (required = true, defaultValue = "!@") String password) {
        if(!(firstname.equals("!@") & password.equals("!@"))) {
            System.out.println(firstname + " " + lastname + " " + " " + password);
            User user = new User();
            user.setUsername(username);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setAge(age);
            user.setEmail(email);
            user.setPassword(password);
            if(userService.saveUser(user))
                System.out.println("GOOD");
            else
                System.out.println("BAD");
        }
        return "redirect:/home";
    }

    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("username", user.getUsername());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("lastname", user.getLastName());
        model.addAttribute("age", user.getAge());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("role", user.getRole());

        return "profile";
    }
}