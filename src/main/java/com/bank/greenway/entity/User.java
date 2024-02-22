package com.bank.greenway.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;

    private String lastname;

    private Integer age;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Account> accounts;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {}

    public User(String firstname, String lastname, Integer age, String email, String password, Set<Account> accounts, Role role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
        this.role = role;
    }
}