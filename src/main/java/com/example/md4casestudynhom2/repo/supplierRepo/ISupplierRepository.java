package com.example.md4casestudynhom2.repo.supplierRepo;

import com.example.md4casestudynhom2.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends CrudRepository<Supplier, Long> {
}
