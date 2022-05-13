package com.example.md4casestudynhom2.repo.appStatusRepo;

import com.example.md4casestudynhom2.model.AppStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends CrudRepository<AppStatus, Long> {
}
