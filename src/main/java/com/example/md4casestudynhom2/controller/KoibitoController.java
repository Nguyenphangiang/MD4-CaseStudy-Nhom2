package com.example.md4casestudynhom2.controller;

import com.example.md4casestudynhom2.model.*;
import com.example.md4casestudynhom2.model.DTO.SupplierForm;
import com.example.md4casestudynhom2.model.supplier_age.SupplierAge;
import com.example.md4casestudynhom2.model.svAndP.ServiceAndPrice;
import com.example.md4casestudynhom2.service.addressService.IAddressService;
import com.example.md4casestudynhom2.service.appServiceS.IAppServiceS;
import com.example.md4casestudynhom2.service.genderService.IGenderService;
import com.example.md4casestudynhom2.service.priceService.IPriceService;
import com.example.md4casestudynhom2.service.serviceAndPrice.IServiceAndPriceSV;
import com.example.md4casestudynhom2.service.statusService.IStatusService;
import com.example.md4casestudynhom2.service.supplierAge.ISupplierAgeSV;
import com.example.md4casestudynhom2.service.supplierService.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/koibito")
@CrossOrigin("*")
public class KoibitoController {

    @Autowired
    private ISupplierService supplierService;

    @Autowired
    private IAddressService addressService;

    @Autowired
    private IStatusService statusService;

    @Autowired
    private IGenderService genderService;

    @Autowired
    private IAppServiceS appServiceS;

    @Autowired
    private IServiceAndPriceSV serviceAndPriceSV;

    @Autowired
    private IPriceService priceService;

    @GetMapping("/price")
    public ResponseEntity<Iterable<Price>> showAll(){
        return new ResponseEntity<>(priceService.findAll(), HttpStatus.OK);
    }


//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Price> updateSupplier(@PathVariable long id, @RequestBody Price price ){
//        priceService.save( new Price(id, price.getPrice(), price.getSupplier()));
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("/deletePrice/{id}")
    public ResponseEntity<Price> deletePrice(@PathVariable Long id) {
        Optional<Price> priceOptional = priceService.findById(id);
        if (!priceOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        priceService.remove(id);
        return new ResponseEntity<>(priceOptional.get(), HttpStatus.NO_CONTENT);
    }

    @Autowired
    Environment env;

    @GetMapping("/findPriceBySupplierId/{id}")
    public ResponseEntity<Iterable<ServiceAndPrice>> showPriceAndName(@PathVariable Long id){
        Iterable<ServiceAndPrice> listPriceAndName = serviceAndPriceSV.getNameAndPrice(id);
        return new ResponseEntity<>(listPriceAndName, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<Iterable<Address>> showAllAddress(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/service")
    public ResponseEntity<Iterable<AppService>> showAllService(){
        return new ResponseEntity<>(appServiceS.findAll(), HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<Iterable<AppStatus>> showAllStatus(){
        return new ResponseEntity<>(statusService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/gender")
    public ResponseEntity<Iterable<Gender>> showAllGender(){
        return new ResponseEntity<>(genderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/listSupplier")
    public ResponseEntity<Iterable<Supplier>> showAllSupplier(){
        return new ResponseEntity<>(supplierService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Supplier> saveSupplier(@ModelAttribute SupplierForm supplierForm) {
        MultipartFile multipartFile = supplierForm.getImage();
        String fileName =multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path");
        try {
            FileCopyUtils.copy(fileName.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Supplier supplier = new Supplier(supplierForm.getName(), supplierForm.getEmail(), supplierForm.getHobby(),
                supplierForm.getAge(), supplierForm.getPersonal(), supplierForm.getNote(), supplierForm.getHeight(),
                supplierForm.getWeight(), fileName, supplierForm.getPhone(), supplierForm.getAddress(),
                supplierForm.getGender(), supplierForm.getServiceSet(), supplierForm.getStatus());
        supplierService.save(supplier);
        return new ResponseEntity<>(supplier,HttpStatus.ACCEPTED);
    }

    @GetMapping("/findOneSupplier/{id}")
    public ResponseEntity<Supplier> findOne(@PathVariable Long id){
        Supplier supplier = supplierService.findById(id).get();
        return new ResponseEntity<>(supplier,HttpStatus.OK);
    }

    @DeleteMapping("/deleteSupplier/{id}")
    public ResponseEntity<Supplier> deleteSupplier(@PathVariable Long id) {
        Optional<Supplier> supplierOptional = supplierService.findById(id);
        if (!supplierOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        supplierService.remove(id);
        return new ResponseEntity<>(supplierOptional.get(), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/editSupplier/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @ModelAttribute SupplierForm supplierForm){
        Optional<Supplier> supplierOptional = supplierService.findById(id);
        supplierForm.setId(supplierOptional.get().getId());
        MultipartFile multipartFile = supplierForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        String fileUpload = env.getProperty("upload.path");
        Supplier existSupplier = new Supplier(id, supplierForm.getName(), supplierForm.getEmail(), supplierForm.getHobby(),
                supplierForm.getAge(), supplierForm.getPersonal(), supplierForm.getNote(), supplierForm.getHeight(),
                supplierForm.getWeight(), fileName, supplierForm.getPhone(), supplierForm.getAddress(),
                supplierForm.getGender(), supplierForm.getServiceSet(), supplierForm.getStatus());
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (existSupplier.getImage().equals("filename.jpg")) {
            existSupplier.setImage(supplierOptional.get().getImage());
        }
        return new ResponseEntity<>(supplierService.save(existSupplier), HttpStatus.OK);
    }

    @Autowired
    private ISupplierAgeSV supplierAgeSV;

    @GetMapping("/supByAgeBetween")
    public ResponseEntity<Iterable<SupplierAge>> findSupplierByAgeBetween(@RequestParam Long age1,
                                                                          @RequestParam Long age2){
        Iterable<SupplierAge> listSupplierAge = supplierAgeSV.getSupplierByAgeBetween(age1, age2);
        return new ResponseEntity<>(listSupplierAge, HttpStatus.OK);
    }

}
