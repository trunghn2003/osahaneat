package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.payload.ResponseData;
import com.cybersoft.osahaneat.payload.request.SignUpRequest;
import com.cybersoft.osahaneat.service.LoginService;
import com.cybersoft.osahaneat.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
//            @Qualifier("tenBean") lay ra dung ra dung class luu tru
    LoginServiceImpl loginServiceImpl;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username,
                                    @RequestParam String password){
        ResponseData responseData= new ResponseData();
        if(loginServiceImpl.checkLogin(username, password)){
            responseData.setData(true);
        }
        else responseData.setData(false);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        ResponseData responseData= new ResponseData();
        responseData.setData(loginServiceImpl.addUser(signUpRequest));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser(){
        ResponseData responseData= new ResponseData();
        responseData.setData(loginServiceImpl.getAllUser());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
