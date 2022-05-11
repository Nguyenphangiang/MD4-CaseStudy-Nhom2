package com.example.md4casestudynhom2.service.appservice;

import com.example.md4casestudynhom2.model.AppService;
import com.example.md4casestudynhom2.repo.IAppServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AppServiceService implements IAppServiceService {
    @Autowired
    private IAppServiceRepo appServiceRepo;
    @Override
    public Iterable<AppService> findAll() {
        return appServiceRepo.findAll();
    }

    @Override
    public Optional<AppService> findById(Long id) {
        return appServiceRepo.findById(id);
    }

    @Override
    public AppService save(AppService appService) {
        return appServiceRepo.save(appService);
    }

    @Override
    public void remove(Long id) {
        appServiceRepo.deleteById(id);
    }
}
