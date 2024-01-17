package com.bank.greenway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

public class BlogController {
    @GetMapping("blog/articles")
    public String create_article(Model model) {
        return "create-article";
    }
}
