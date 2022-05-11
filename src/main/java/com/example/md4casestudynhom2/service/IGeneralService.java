package com.example.md4casestudynhom2.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save (T t);

    void remove(Long id);
}
