package com.cybersoft.osahaneat.security;

import com.cybersoft.osahaneat.entity.Users;
import com.cybersoft.osahaneat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username);
//        System.out.println(username+" " + users.getPassword());
        if(username == null){
            throw new UsernameNotFoundException("User doesn't exit");
        }
        return new User(username, users.getPassword(),new ArrayList<>());




    }
}
