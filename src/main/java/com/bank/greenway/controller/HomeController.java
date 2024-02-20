package com.bank.greenway.controller;

import com.bank.greenway.entity.Account;
import com.bank.greenway.repository.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("title", "hello");
        return "hello";
    }
}
