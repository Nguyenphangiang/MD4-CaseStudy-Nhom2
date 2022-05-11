package com.example.md4casestudynhom2.model;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class AppStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;
}
