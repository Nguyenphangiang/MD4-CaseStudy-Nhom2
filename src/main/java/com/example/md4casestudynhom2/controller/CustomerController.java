package com.example.md4casestudynhom2.controller;

import com.example.md4casestudynhom2.model.Customer;
import com.example.md4casestudynhom2.model.Gender;
import com.example.md4casestudynhom2.service.IGeneralService;
import com.example.md4casestudynhom2.service.customer.ICustomerService;
import com.example.md4casestudynhom2.service.gender.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CustomerController{

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IGenderService genderService;

    @ModelAttribute
    public Iterable<Gender> genders(){
        return genderService.findAll();
    }


    @GetMapping("/listCustomer")
    public ResponseEntity<Iterable<Customer>> getAllCustomer(){
        Iterable<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/listCustomer")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/gender")
    public ResponseEntity<Iterable<Gender>> getGender(){
        Iterable<Gender> genders = genderService.findAll();
        return new ResponseEntity<>(genders, HttpStatus.OK);
    }

    @DeleteMapping("/listCustomer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Optional<Customer> customerOptional = customerService.findById(id);
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/listCustomer/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Long id,@RequestBody Customer customer){
        Optional<Customer> customerOptional = customerService.findById(id);
        customer.setId(customerOptional.get().getId());
        if (!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.save(customer);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

}
