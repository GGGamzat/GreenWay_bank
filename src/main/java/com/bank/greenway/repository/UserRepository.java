package com.bank.greenway.repository;

import com.bank.greenway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByFirstname(String firstname);
    User findByLastname(String lastname);
    User findByAge(Integer age);
    User findByEmail(String email);
}