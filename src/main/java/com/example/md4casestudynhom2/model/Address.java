package com.example.md4casestudynhom2.model;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;

@Entity
@Table(name= "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address() {
    }

    public Address(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public Address(String address) {
        this.address = address;
    }
}
