package com.example.md4casestudynhom2.repo;

import com.example.md4casestudynhom2.model.Gender;
import org.springframework.data.repository.CrudRepository;

public interface IGenderRepo extends CrudRepository<Gender, Long> {
    Iterable<Gender> findGenderByGender(String gender);
}
