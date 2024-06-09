package com.bank.greenway.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer amount;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Account account_from;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Account account_to;

    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Account getAccount_From() {
        return account_from;
    }

    public void setAccount_From(Account account_from) {
        this.account_from = account_from;
    }

    public Account getAccount_To() {
        return account_to;
    }

    public void setAccount_To(Account account_to) {
        this.account_to = account_to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Transaction() {}

    public Transaction(Integer amount, Account account_from, Account account_to, LocalDate date) {
        this.amount = amount;
        this.account_from = account_from;
        this.account_to = account_to;
        this.date = date;
    }
}
