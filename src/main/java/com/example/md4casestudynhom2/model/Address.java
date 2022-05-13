package com.example.md4casestudynhom2.model;

//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

//    private Set<Supplier> supplierSet = new HashSet<>();
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
