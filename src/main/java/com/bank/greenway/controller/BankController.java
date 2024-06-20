package com.bank.greenway.controller;

import com.bank.greenway.entity.Account;
import com.bank.greenway.entity.Transaction;
import com.bank.greenway.entity.User;
import com.bank.greenway.repository.AccountRepository;
import com.bank.greenway.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

@Controller
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/open-account")
    public String openAccount() {
        return "open-account";
    }

    @PostMapping("/open-account")
    public String openAccount(@RequestParam(required = false) Integer number, @RequestParam Integer balance, @AuthenticationPrincipal User user) {
        Account account = new Account(number, balance, user);

        Random rn = new Random();
        int randomNum = rn.nextInt(2000 - 1000 + 1) + 1000;

        account.setNumber(randomNum);
        accountRepository.save(account);
        return "redirect:/home";
    }

    @GetMapping("/execute-transaction")
    public String execute_transaction() {
        return "execute-transaction";
    }

    @PostMapping("/execute-transaction")
    public String execute_transaction_post(@RequestParam Integer amount, @RequestParam Account account_from, @RequestParam Account account_to) {
        Transaction transaction = new Transaction(amount, account_from, account_to);

        transaction.setAmount(amount);
        transaction.setAccount_To(account_from);
        transaction.setAccount_To(account_to);
        transactionRepository.save(transaction);

        transaction = transactionRepository.save(transaction);
        Account sender = accountRepository.findById(transaction.getAccount_From().getId()).orElseThrow();
        Account recipient = accountRepository.findById(transaction.getAccount_To().getId()).orElseThrow();

        sender.setBalance(transaction.getAccount_From().getBalance() - transaction.getAmount());
        accountRepository.save(sender);
        recipient.setBalance(transaction.getAccount_To().getBalance() + transaction.getAmount());
        accountRepository.save(recipient);
        return "redirect:/home";
    }
}