package com.example.md4casestudynhom2.service.supplierAge;


import com.example.md4casestudynhom2.model.supplier_age.SupplierAge;
import com.example.md4casestudynhom2.repo.supplierRepo.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SupplierAgeSV implements ISupplierAgeSV{
    @Autowired
    ISupplierRepository supplierAgeRepo;
    @Override
    public Iterable<SupplierAge> findAll() {
        return null;
    }

    @Override
    public Optional<SupplierAge> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public SupplierAge save(SupplierAge supplierAge) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }



    @Override
    public Iterable<SupplierAge> getSupplierByAgeBetween(Long age1, Long age2) {
        return supplierAgeRepo.getSupplierByAgeBetween(age1, age2);
    }
}
