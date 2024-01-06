package com.cybersoft.osahaneat.service.impl;

import com.cybersoft.osahaneat.dto.UsersDTO;
import com.cybersoft.osahaneat.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImpl {
    List<UsersDTO> getAllUser();
    boolean checkLogin(String username, String password);

    boolean addUser(SignUpRequest signUpRequest);

}
