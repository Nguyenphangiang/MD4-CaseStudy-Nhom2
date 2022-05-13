package com.example.md4casestudynhom2.repo.priceRepo;

import com.example.md4casestudynhom2.model.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepository extends CrudRepository<Price, Long> {
}
