package com.example.md4casestudynhom2.controller;

import com.example.md4casestudynhom2.model.AppService;
import com.example.md4casestudynhom2.model.Price;

import com.example.md4casestudynhom2.model.Supplier;
import com.example.md4casestudynhom2.service.appServiceS.IAppServiceS;
import com.example.md4casestudynhom2.service.priceService.IPriceService;
import com.example.md4casestudynhom2.service.supplierService.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    private IPriceService priceService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IAppServiceS appServiceS;

    @GetMapping
    public ResponseEntity<Iterable<Price>> findAll(){
        Iterable<Price> prices = priceService.findAll();
        return new ResponseEntity<>(prices, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> findById(@PathVariable Long id){
        Price price = priceService.findById(id).get();
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Price> savePrice(@RequestBody Price price){
        return new ResponseEntity<>(priceService.save(price), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long id, @RequestBody Price price){
        Optional<Price> priceOptional = priceService.findById(id);
        Long supplier_id = priceOptional.get().getSupplier().getId();
        Long service_id = priceOptional.get().getAppService().getId();
        Optional<Supplier> supplierOptional = supplierService.findById(supplier_id);
        Supplier updateSupplier = supplierOptional.get();
        Optional<AppService> serviceOptional = appServiceS.findById(service_id);
        AppService updateService = serviceOptional.get();
        Price updatePrice = new Price(id, price.getPrice(), updateSupplier, updateService);
        priceService.save(updatePrice);
        return new ResponseEntity<>(priceOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Price> deletePrice(@PathVariable Long id){
        Price price = priceService.findById(id).get();
        if (price!=null) priceService.remove(id);
        return new ResponseEntity<>(price, HttpStatus.OK);}


}
