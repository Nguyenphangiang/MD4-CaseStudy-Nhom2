package com.example.md4casestudynhom2.repo.login;

import com.example.md4casestudynhom2.model.login.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppUserRepo  extends JpaRepository<AppUser,Long> {
    Optional<AppUser> findByName(String name);
}