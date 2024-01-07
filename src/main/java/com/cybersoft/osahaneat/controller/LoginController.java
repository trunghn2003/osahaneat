package com.cybersoft.osahaneat.controller;

import com.cybersoft.osahaneat.Utils.JwtUtilsHelper;
import com.cybersoft.osahaneat.payload.ResponseData;
import com.cybersoft.osahaneat.payload.request.SignUpRequest;
import com.cybersoft.osahaneat.service.LoginService;
import com.cybersoft.osahaneat.service.impl.LoginServiceImpl;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
//            @Qualifier("tenBean") lay ra dung ra dung class luu tru
    LoginServiceImpl loginServiceImpl;

    @Autowired
    JwtUtilsHelper jwtUtilsHelper;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username,
                                    @RequestParam String password){
        ResponseData responseData= new ResponseData();

//        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//        String jwtKey = Encoders.BASE64.encode(key.getEncoded());
//        System.out.println("Key: " + jwtKey);

        if(loginServiceImpl.checkLogin(username, password)){

            String token = jwtUtilsHelper.generateToken(username);
            System.out.println(token);
            responseData.setData(token);
//            responseData.setSucess(true);

        }
        else {
            responseData.setData("");
            responseData.setSucess(false);
        }

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
