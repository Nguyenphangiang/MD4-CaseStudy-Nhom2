package com.example.md4casestudynhom2.service.price;

import com.example.md4casestudynhom2.model.Price;
import com.example.md4casestudynhom2.repo.IPriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PriceService implements IPriceService{
    @Autowired
    private IPriceRepo priceRepo;
    @Override
    public Iterable<Price> findAll() {
        return priceRepo.findAll();
    }

    @Override
    public Optional<Price> findById(Long id) {
        return priceRepo.findById(id);
    }

    @Override
    public Price save(Price price) {
        return priceRepo.save(price);
    }

    @Override
    public void remove(Long id) {
        priceRepo.deleteById(id);
    }
}
