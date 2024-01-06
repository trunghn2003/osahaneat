package com.cybersoft.osahaneat.service.impl;

import com.cybersoft.osahaneat.dto.UsersDTO;

import java.util.List;

public interface LoginServiceImpl {
    List<UsersDTO> getAllUser();
    boolean checkLogin(String username, String password);

}
