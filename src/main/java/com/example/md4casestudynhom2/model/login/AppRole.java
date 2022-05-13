package com.example.md4casestudynhom2.model.login;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AppRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AppRole() {
    }
}
