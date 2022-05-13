package com.example.md4casestudynhom2.service.priceService;

import com.example.md4casestudynhom2.model.Price;
import com.example.md4casestudynhom2.repo.priceRepo.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PriceService implements IPriceService{

    @Autowired
    private IPriceRepository priceRepository;

    @Override
    public Iterable<Price> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public Optional<Price> findById(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public Price save(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public void remove(Long id) {
        priceRepository.deleteById(id);
    }
}
