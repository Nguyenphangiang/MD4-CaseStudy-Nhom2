package com.example.md4casestudynhom2.service.login.appuser;

import com.example.md4casestudynhom2.model.login.AppUser;
import com.example.md4casestudynhom2.service.login.IGeneralLoginService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGeneralLoginService<AppUser>, UserDetailsService {
    AppUser findByName(String name);
}
