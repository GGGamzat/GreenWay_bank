//package com.bank.greenway.service.impl;
//
//import java.lang.Override;
//
//import com.bank.greenway.entity.Account;
//import com.bank.greenway.repository.AccountRepository;
//import com.bank.greenway.service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountServiceImpl implements AccountService {
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Override
//    public Account createAccount(Account account) {
//        Account savedAccount = accountRepository.save(account);
//        return savedAccount;
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        accountRepository.deleteById(id);
//    }
//
//    @Override
//    public Account getBalance(Integer balance) {
//        return accountRepository.findByBalance(balance);
//    }
//
//    @Override
//    public Account editAccount(Account account) {
//        return accountRepository.save(account);
//    }
//}
