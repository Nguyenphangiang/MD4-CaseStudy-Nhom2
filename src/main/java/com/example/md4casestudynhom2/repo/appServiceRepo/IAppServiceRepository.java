package com.example.md4casestudynhom2.repo.appServiceRepo;

import com.example.md4casestudynhom2.model.AppService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppServiceRepository extends CrudRepository<AppService, Long> {
}
