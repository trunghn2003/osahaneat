package com.cybersoft.osahaneat.service;

import com.cybersoft.osahaneat.dto.UsersDTO;
import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.cybersoft.osahaneat.repository.UserRepository;

@Service
public class LoginService implements LoginServiceImpl {
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

    @Override
    public boolean checkLogin(String username, String password) {
        List<Users> listUser = userRepository.findByUsernameAndPassword(username,password);
        return  listUser.size()>0;
    }

    ;


}
