package com.example.md4casestudynhom2.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "services")
public class AppService {
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

    public AppService(String name) {
        this.name = name;
    }

    public AppService(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public AppService() {
    }
}
