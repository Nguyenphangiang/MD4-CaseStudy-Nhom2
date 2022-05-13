package com.example.md4casestudynhom2.model.DTO;




import com.example.md4casestudynhom2.model.login.AppRole;
import com.example.md4casestudynhom2.validator.PasswordConfirm;
import com.example.md4casestudynhom2.validator.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

public class UserForm   {

    private Long id;

    @UniqueUsername
    @NotEmpty(message = "Please enter user name.")
    @Size(min = 3, max = 15,message = "3 - 15 characters.")
    private String name;

//    @PasswordConfirm
//    private PasswordForm passwordForm;
    private String password;

    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserForm(Long id, String name, String password, String confirmPassword, String email, Set<AppRole> roleSet) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.roleSet = roleSet;
    }

    @Email
    @NotEmpty(message = "Please enter email.")
    private String email;

    private Set<AppRole> roleSet;

//    public PasswordForm getPasswordForm() {
//        return passwordForm;
//    }

//    public void setPasswordForm(PasswordForm passwordForm) {
//        this.passwordForm = passwordForm;
//    }

    public UserForm(String name, PasswordForm passwordForm, String email, Set<AppRole> roleSet) {
        this.name = name;
//        this.passwordForm = passwordForm;
        this.email = email;
        this.roleSet = roleSet;
    }

    public UserForm(Long id, String name, PasswordForm passwordForm, String email, Set<AppRole> roleSet) {
        this.id = id;
        this.name = name;
//        this.passwordForm = passwordForm;
        this.email = email;
        this.roleSet = roleSet;
    }

    public Set<AppRole> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<AppRole> roleSet) {
        this.roleSet = roleSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public UserForm() {
        System.out.println("Demo");
    }
}
