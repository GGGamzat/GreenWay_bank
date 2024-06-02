package com.bank.greenway.controller;

import java.util.Optional;
import java.util.ArrayList;
import com.bank.greenway.entity.Article;
import com.bank.greenway.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BlogController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blog/articles")
    public String get_articles(Model model) {
        Iterable<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles";
    }

    @GetMapping("/blog/articles/{id}")
    public String get_articleDetail(@PathVariable(value="id") Long id, Model model) {
        if(!articleRepository.existsById(id)) {
            return "redirect:/home";
        }

        Optional<Article> article = articleRepository.findById(id);
        ArrayList<Article> res = new ArrayList<>();
        article.ifPresent(res::add);
        model.addAttribute("article", res);
        return "article";
    }

    @GetMapping("/blog/create-article")
    public String create_article(Model model) {
        return "create-article";
    }

    @PostMapping("/blog/create-article")
    public String create_article_post(@RequestParam String title, @RequestParam String text, Model model) {
        Article article = new Article(title, text);
        articleRepository.save(article);
        return "redirect:/home";
    }
}
