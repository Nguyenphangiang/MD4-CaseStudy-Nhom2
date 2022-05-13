package com.example.md4casestudynhom2.service.genderService;

import com.example.md4casestudynhom2.model.Gender;
import com.example.md4casestudynhom2.repo.genderRepo.IGenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GenderService implements IGenderService {

    @Autowired
    private IGenderRepository genderRepository;

    @Override
    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> findById(Long id) {
        return Optional.empty();
    }


    @Override
    public Gender save(Gender gender) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
