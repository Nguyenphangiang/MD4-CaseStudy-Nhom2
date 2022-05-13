package com.example.md4casestudynhom2.validator;

import com.example.md4casestudynhom2.model.login.AppUser;
import com.example.md4casestudynhom2.repo.login.IAppUserRepo;
import com.example.md4casestudynhom2.service.login.appuser.IAppUserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator  implements ConstraintValidator<UniqueUsername,String> {
    private IAppUserRepo userRepo;
    public UniqueUsernameValidator(IAppUserRepo userRepo){
        this.userRepo = userRepo;
    }
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        AppUser user = userRepo.findByName(username).get();
        if (user != null){
            return false;
        }
        return true;
    }
}
