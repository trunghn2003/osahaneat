package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.dto.UsersDTO;
import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.repository.UserInterface;
import com.cybersoft.osahaneat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
//            @Qualifier("tenBean") lay ra dung ra dung class luu tru
    LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(){


        return new ResponseEntity<>(loginService.getAllUser(), HttpStatus.OK);
    }
}
