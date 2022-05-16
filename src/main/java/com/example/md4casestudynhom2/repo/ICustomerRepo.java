package com.example.md4casestudynhom2.repo;

import com.example.md4casestudynhom2.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Long> {
    @Query(nativeQuery = true, value = "select * from customers where name like ?;")
    Iterable<Customer> findByNameContain(String name);
}
