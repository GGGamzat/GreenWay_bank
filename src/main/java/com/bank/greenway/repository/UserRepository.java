package com.bank.greenway.repository;

import java.util.List;

import com.bank.greenway.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}