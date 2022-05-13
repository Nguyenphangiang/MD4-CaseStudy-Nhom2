package com.example.md4casestudynhom2.repo;

import com.example.md4casestudynhom2.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepo extends JpaRepository<Price, Long> {
}
