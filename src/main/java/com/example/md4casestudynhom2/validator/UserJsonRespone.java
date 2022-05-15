package com.example.md4casestudynhom2.validator;

import com.example.md4casestudynhom2.model.DTO.UserForm;

import java.util.Map;

public class UserJsonRespone {
    private UserForm userForm;
    private boolean validated;
    private Map<String,String> errorMessage;

    public UserForm getUserForm() {
        return userForm;
    }

    public void setUserForm(UserForm userForm) {
        this.userForm = userForm;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Map<String, String> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Map<String, String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UserJsonRespone() {
    }

    public UserJsonRespone(UserForm userForm, boolean validated, Map<String, String> errorMessage) {
        this.userForm = userForm;
        this.validated = validated;
        this.errorMessage = errorMessage;
    }
}
