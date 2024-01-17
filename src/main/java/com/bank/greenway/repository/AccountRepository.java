package com.bank.greenway.repository;

import com.bank.greenway.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByBalance(Integer balance);
    void deleteById(Long id);
}
