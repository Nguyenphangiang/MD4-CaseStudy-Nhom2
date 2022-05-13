package com.example.md4casestudynhom2.repo.genderRepo;

import com.example.md4casestudynhom2.model.Gender;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenderRepository extends CrudRepository<Gender, Long> {
}
