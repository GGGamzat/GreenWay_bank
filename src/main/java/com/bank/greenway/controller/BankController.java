package com.bank.greenway.controller;

import com.bank.greenway.entity.Account;
import com.bank.greenway.entity.User;
import com.bank.greenway.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class BankController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/bank/open-account")
    public String openAccount() {
        return "open-account";
    }

    @PostMapping("/bank/open-account")
    public String openAccount(@RequestParam(required = false) Integer number, @RequestParam Integer balance, @AuthenticationPrincipal User user) {
        Account account = new Account(number, balance, user);

        Random rn = new Random();
        int randomNum = rn.nextInt(2000 - 1000 + 1) + 1000;

        account.setNumber(randomNum);
        accountRepository.save(account);
        return "redirect:/home";
    }
}