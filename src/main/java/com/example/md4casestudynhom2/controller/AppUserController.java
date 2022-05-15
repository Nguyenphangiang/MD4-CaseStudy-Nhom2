package com.example.md4casestudynhom2.controller;

import com.example.md4casestudynhom2.model.login.AppUser;
import com.example.md4casestudynhom2.model.DTO.UserForm;
import com.example.md4casestudynhom2.service.email.EmailSenderService;
import com.example.md4casestudynhom2.service.login.appuser.IAppUserService;

import com.example.md4casestudynhom2.validator.UserJsonRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/sign-in")
public class AppUserController {
    @Autowired
    private IAppUserService appUserService;
    @Autowired
    private EmailSenderService senderService;

    @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE } )
    @ResponseBody
    public UserJsonRespone createUser(@ModelAttribute  @Valid UserForm userForm, BindingResult bindingResult){
//        if (!userForm.getPasswordForm().getPassword().equals(userForm.getPasswordForm().getConfirmPassword())){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        UserJsonRespone respone = new UserJsonRespone();
        if (bindingResult.hasErrors()){
            Map<String,String> errors = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            respone.setValidated(false);
            respone.setErrorMessage(errors);

//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            respone.setValidated(true);
            respone.setUserForm(userForm);
            AppUser user = new AppUser(userForm.getName(),userForm.getPassword(),userForm.getRoleSet());
            sendMail(userForm.getEmail(),userForm.getName(), userForm.getPassword());
            appUserService.save(user);
//            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
        return respone;
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
