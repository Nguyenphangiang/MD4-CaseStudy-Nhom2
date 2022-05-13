package com.example.md4casestudynhom2.repo.billRepo;

import com.example.md4casestudynhom2.model.AppStatus;
import com.example.md4casestudynhom2.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends CrudRepository<Bill, Long> {
}
