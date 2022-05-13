package com.example.md4casestudynhom2.repo.addressRepo;

import com.example.md4casestudynhom2.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends CrudRepository<Address, Long> {
}
