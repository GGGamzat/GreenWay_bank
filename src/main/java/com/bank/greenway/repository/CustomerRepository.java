package com.bank.greenway.repository;

import java.util.List;

import com.bank.greenway.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findBylastName(String lastname);
}