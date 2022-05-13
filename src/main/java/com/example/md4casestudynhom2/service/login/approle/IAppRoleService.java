package com.example.md4casestudynhom2.service.login.approle;

import com.example.md4casestudynhom2.model.login.AppRole;
import com.example.md4casestudynhom2.service.login.IGeneralLoginService;

public interface IAppRoleService extends IGeneralLoginService<AppRole> {
    AppRole findByName(String name);
}
