package com.example.md4casestudynhom2.model;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int price;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Price(int price, Supplier supplier) {
        this.price = price;
        this.supplier = supplier;
    }

    public Price(Long id, int price, Supplier supplier) {
        this.id = id;
        this.price = price;
        this.supplier = supplier;
    }

    public Price() {
    }
}
