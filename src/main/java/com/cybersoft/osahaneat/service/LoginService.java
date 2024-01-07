package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.UsersDTO;
import com.cybersoft.osahaneat.entity.Roles;
import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.payload.request.SignUpRequest;
import com.cybersoft.osahaneat.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.cybersoft.osahaneat.repository.UserRepository;

@Service
public class LoginService implements LoginServiceImpl {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public List<UsersDTO> getAllUser(){
        List<Users> usersList =  userRepository.findAll();
        List<UsersDTO> usersListDTO =  new ArrayList<>();


        for(Users i: usersList){
            UsersDTO x = new UsersDTO();
            x.setId(i.getId());
            x.setUsername(i.getUsername());
            x.setPassword(i.getPassword());
            x.setFullname(i.getFullname());
            usersListDTO.add(x);

//            System.out.println(i.getFullname() + " " + i.getPassword());
        }
        return usersListDTO;

    }

    @Override
    public boolean checkLogin(String username, String password) {
        Users users =  userRepository.findByUsername(username);
        return passwordEncoder.matches(password,users.getPassword());
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());

        Users users = new Users();
        users.setFullname(signUpRequest.getFullname());
        users.setUsername(signUpRequest.getUsername());
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);
        try {
            userRepository.save(users);
            return  true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }



    ;


}
