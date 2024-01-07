package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.UsersDTO;
import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.repository.UserRepository;
import com.cybersoft.osahaneat.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserServiceImpl {
    @Autowired
    UserRepository userRepository;
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

            System.out.println(i.getFullname() + " " + i.getPassword());
        }
        return usersListDTO;

    }
}
