package com.bank.greenway.controller;

import com.bank.greenway.entity.User;
import com.bank.greenway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private UserService userService;

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
}