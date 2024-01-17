package com.bank.greenway.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
    private Set<Customer> customers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getUsers() {
        return customers;
    }

    public void setUsers(Set<Customer> customers) {
        this.customers = customers;
    }

    public Role() {}

    public Role(String name, Set<Customer> customers) {
        this.name = name;
        this.customers = customers;
    }
}
