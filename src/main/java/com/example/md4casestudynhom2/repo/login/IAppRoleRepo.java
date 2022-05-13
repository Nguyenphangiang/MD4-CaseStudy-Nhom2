package com.example.md4casestudynhom2.repo.login;

import com.example.md4casestudynhom2.model.login.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppRoleRepo extends JpaRepository<AppRole,Long> {
    AppRole findByName(String name);
}
