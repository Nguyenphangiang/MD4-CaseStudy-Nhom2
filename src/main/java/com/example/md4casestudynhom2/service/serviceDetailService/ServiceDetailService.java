package com.example.md4casestudynhom2.service.serviceDetailService;

import com.example.md4casestudynhom2.model.AppService;
import com.example.md4casestudynhom2.model.ServiceDetail;
import com.example.md4casestudynhom2.model.serviceDetail.AppServiceDetail;
import com.example.md4casestudynhom2.repo.serviceDetailRepo.IAppServiceDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceDetailService implements IServiceDetailService {
    @Autowired
    private IAppServiceDetailRepo repository;

    @Override
    public Iterable<ServiceDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ServiceDetail> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ServiceDetail save(ServiceDetail serviceDetail) {
        return repository.save(serviceDetail);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AppServiceDetail> findPriceByServiceIdAndSupplierId(Long idSupplier, Long idService) {
        return repository.findPriceByServiceIdAndSupplierId(idSupplier,idService);
    }
}
