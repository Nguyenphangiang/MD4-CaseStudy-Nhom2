package com.example.md4casestudynhom2.controller;

import com.example.md4casestudynhom2.model.login.AppUser;
import com.example.md4casestudynhom2.model.DTO.UserForm;
import com.example.md4casestudynhom2.service.email.EmailSenderService;
import com.example.md4casestudynhom2.service.login.appuser.IAppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/sign-up")
public class AppUserController {
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private EmailSenderService senderService;

    @PostMapping("")
    public ResponseEntity<AppUser> createUser( @ModelAttribute UserForm userForm){
//        if (!userForm.getPasswordForm().getPassword().equals(userForm.getPasswordForm().getConfirmPassword())){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
            AppUser user = new AppUser(userForm.getName(),userForm.getPassword(),userForm.getRoleSet());
            sendMail(userForm.getEmail(),userForm.getName(), userForm.getPassword());
            appUserService.save(user);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
    @GetMapping("/list")
    public ResponseEntity<Iterable<AppUser>> showAll(){
        return new ResponseEntity<>(appUserService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AppUser> deleteUser(@PathVariable Long id){
        appUserService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public void sendMail(String email,String name,String password){
        senderService.sendEmail(email,
                "Welcome",
                "Welcome to koibito <3 !!  sign up successfully !!!"
        + " Your user name : " + name + " Your password " + password);
    }
}
