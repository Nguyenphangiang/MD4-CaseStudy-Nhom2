package com.example.md4casestudynhom2.controller;

import com.example.md4casestudynhom2.model.AppService;
import com.example.md4casestudynhom2.service.appservice.IAppServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/app_service")
public class AppServiceController {
    @Autowired
    private IAppServiceService appServiceService;

    @GetMapping
    public ResponseEntity<Iterable<AppService>> findAll(){
        Iterable<AppService> appServices = appServiceService.findAll();
        return new ResponseEntity<>(appServices, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppService> findById(@PathVariable Long id){
        AppService appService = appServiceService.findById(id).get();
        return new ResponseEntity<>(appService, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppService> saveAppService(@RequestBody AppService appService){
        return new ResponseEntity<>(appServiceService.save(appService),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppService> updateAppService(@PathVariable Long id, @RequestBody AppService appService){
        Optional<AppService> appServiceOptional = appServiceService.findById(id);
        appService.setId(appServiceOptional.get().getId());
        if (!appServiceOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        appServiceService.save(appService);
        return new ResponseEntity<>(appServiceOptional.get(),HttpStatus.OK);
//        appService.setId(id);
//        appServiceService.save(appService);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AppService> deleteAppService(@PathVariable Long id){
        AppService appService = appServiceService.findById(id).get();
        if (appService!= null) appServiceService.remove(id);
        return new ResponseEntity<>(appService, HttpStatus.OK);
    }




}
