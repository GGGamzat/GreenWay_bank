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
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Role() {}

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }
}
