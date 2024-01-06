package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.UsersDTO;
import com.cybersoft.osahaneat.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.cybersoft.osahaneat.repository.UserInterface;

@Service
public class LoginService {
    @Autowired
    UserInterface userInterface;
    public List<UsersDTO> getAllUser(){
        List<Users> usersList =  userInterface.findAll();
        List<UsersDTO> usersListDTO =  new ArrayList<>();


        for(Users i: usersList){
            UsersDTO x = new UsersDTO();
            x.setId(i.getId());
            x.setUsername(i.getUsername());
            x.setPassword(i.getPassword());
            x.setFullname(i.getFullname());
            usersListDTO.add(x);

            System.out.println(i.getFullname() + " " + i.getPassword());
        }
        return usersListDTO;

    };
}
