package com.example.md4casestudynhom2.validator;

import com.example.md4casestudynhom2.model.DTO.PasswordForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<PasswordConfirm, PasswordForm> {
    @Override
    public boolean isValid(PasswordForm passwordForm, ConstraintValidatorContext context){
        return passwordForm.getPassword().equals(passwordForm.getConfirmPassword());
    }

}
