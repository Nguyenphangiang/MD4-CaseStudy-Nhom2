package com.example.md4casestudynhom2.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_details")
public class ServiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private AppService service;
    @ManyToOne
    @JoinColumn(name= "supplier_id")
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ServiceDetail(AppService service, Supplier supplier, LocalDateTime meetTime, String meetAddress) {
        this.service = service;
        this.supplier = supplier;
        this.meetTime = meetTime;
        this.meetAddress = meetAddress;
    }

    public ServiceDetail(Long id, AppService service, Supplier supplier, LocalDateTime meetTime, String meetAddress) {
        this.id = id;
        this.service = service;
        this.supplier = supplier;
        this.meetTime = meetTime;
        this.meetAddress = meetAddress;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime meetTime;

    private String meetAddress;

    public ServiceDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppService getService() {
        return service;
    }

    public void setService(AppService service) {
        this.service = service;
    }

    public LocalDateTime getMeetTime() {
        return meetTime;
    }

    public void setMeetTime(LocalDateTime meetTime) {
        this.meetTime = meetTime;
    }

    public String getMeetAddress() {
        return meetAddress;
    }

    public void setMeetAddress(String meetAddress) {
        this.meetAddress = meetAddress;
    }

    public ServiceDetail(AppService service, LocalDateTime meetTime, String meetAddress) {
        this.service = service;
        this.meetTime = meetTime;
        this.meetAddress = meetAddress;
    }

    public ServiceDetail(Long id, AppService service, LocalDateTime meetTime, String meetAddress) {
        this.id = id;
        this.service = service;
        this.meetTime = meetTime;
        this.meetAddress = meetAddress;
    }
}
