package com.securityuserDetails.securityuserDetails.service;

import com.securityuserDetails.securityuserDetails.model.CustomUserDetails;
import com.securityuserDetails.securityuserDetails.model.Users;
import com.securityuserDetails.securityuserDetails.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByUsername(username);

        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("User name not found"));

        return optionalUsers
                .map(CustomUserDetails::new).get();

    }
}
