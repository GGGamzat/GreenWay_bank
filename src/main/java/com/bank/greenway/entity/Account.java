package com.bank.greenway.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="number")
    private Integer number;

    @Column(name="balance")
    private Integer balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account() {}

    public Account(Integer number, Integer balance, User user) {
        this.number = number;
        this.balance = balance;
        this.user = user;
    }
}
