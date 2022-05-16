package com.example.md4casestudynhom2.controller;

import com.example.md4casestudynhom2.model.AppService;
import com.example.md4casestudynhom2.model.ServiceDetail;
import com.example.md4casestudynhom2.model.Supplier;
import com.example.md4casestudynhom2.model.serviceDetail.AppServiceDetail;
import com.example.md4casestudynhom2.repo.serviceDetailRepo.IAppServiceDetailRepo;
import com.example.md4casestudynhom2.service.appServiceS.IAppServiceS;
import com.example.md4casestudynhom2.service.serviceDetailService.IServiceDetailService;
import com.example.md4casestudynhom2.service.supplierService.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class ServiceDetailController {
    @Autowired
    private IServiceDetailService serviceDetailService;
    @Autowired
    private ISupplierService supplierService;
    @Autowired
    private IAppServiceS appServiceS;


    @GetMapping("")
    private ResponseEntity<Iterable<ServiceDetail>> showServiceDetail(){
        return new ResponseEntity<>(serviceDetailService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    private ResponseEntity<ServiceDetail> saveServiceDetail(@RequestBody ServiceDetail serviceDetail){
       return new ResponseEntity<>(serviceDetailService.save(serviceDetail),HttpStatus.ACCEPTED) ;
    }
    @GetMapping("/serviceDetail/{id}/service/{serviceId}")
    private ResponseEntity<AppServiceDetail> getServiceAndPriceByServiceIdAndPriceId(@PathVariable Long id,@PathVariable Long serviceId){
        Optional<AppServiceDetail> appServiceDetail = serviceDetailService.findPriceByServiceIdAndSupplierId(id,serviceId);
        return new ResponseEntity<>(appServiceDetail.get(),HttpStatus.OK);
    }
    @PutMapping("/updateCart")
    private ResponseEntity<ServiceDetail> updateServiceDetail(@RequestBody ServiceDetail serviceDetail){
        return new ResponseEntity<>(serviceDetailService.save(serviceDetail),HttpStatus.OK);
    }
    @GetMapping("/findOne/{id}")
    private ResponseEntity<ServiceDetail> findOneById(@PathVariable Long id){
        Optional<ServiceDetail> optionalServiceDetail = serviceDetailService.findById(id);
        return new ResponseEntity<>(optionalServiceDetail.get(),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<ServiceDetail> deleteCart(@PathVariable Long id){
        serviceDetailService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
