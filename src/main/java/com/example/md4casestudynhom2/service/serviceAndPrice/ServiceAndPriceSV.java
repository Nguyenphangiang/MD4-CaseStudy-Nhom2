package com.example.md4casestudynhom2.service.serviceAndPrice;

import com.example.md4casestudynhom2.model.svAndP.ServiceAndPrice;
//import com.example.md4casestudynhom2.repo.serviceAndPriceRepo.IServiceAndPriceRepo;
import com.example.md4casestudynhom2.repo.supplierRepo.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ServiceAndPriceSV implements IServiceAndPriceSV{

    @Autowired
    private ISupplierRepository serviceAndPriceRepo;

    @Override
    public Iterable<ServiceAndPrice> findAll() {
        return null;
    }

    @Override
    public Optional<ServiceAndPrice> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ServiceAndPrice save(ServiceAndPrice serviceAndPrice) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<ServiceAndPrice> getNameAndPrice(Long idSp) {
        return serviceAndPriceRepo.getNameAndPrice(idSp);
    }
}
