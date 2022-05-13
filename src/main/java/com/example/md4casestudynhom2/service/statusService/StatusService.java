package com.example.md4casestudynhom2.service.statusService;

import com.example.md4casestudynhom2.model.AppStatus;
import com.example.md4casestudynhom2.repo.appStatusRepo.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusService implements IStatusService{

    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public Iterable<AppStatus> findAll() {
        return statusRepository.findAll();
    }

    @Override
    public Optional<AppStatus> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public AppStatus save(AppStatus appStatus) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
