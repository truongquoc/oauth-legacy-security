package com.example.oauthlegacysecurity.service;

import com.example.oauthlegacysecurity.entity.User;
import com.example.oauthlegacysecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> {
            log.error("User not found with username: " + username);
            return new UsernameNotFoundException("User not found with username: " + username);
        });

        return UserDetailsImpl.build(user);
    }

}
