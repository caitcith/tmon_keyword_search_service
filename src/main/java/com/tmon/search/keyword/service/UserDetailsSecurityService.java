package com.tmon.search.keyword.service;

import com.tmon.search.keyword.domain.User;
import com.tmon.search.keyword.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class UserDetailsSecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    Map<String, User> userMap = new ConcurrentHashMap<>();

    public void usersLoadToMemory() {
        Iterable<User> users = userRepository.findAll();

        for (User user : users) {
            userMap.put(user.getUsername(), user);
        }
    }

    public User saveUser(User user) {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        User savedUser = userRepository.save(user);

        return savedUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userMap.get(username);
        if (foundUser == null ) throw new UsernameNotFoundException(username + "에 해당하는 정보를 찾을 수 없습니다.");
        log.info("userInfo({})", foundUser);

        return foundUser;
    }
}
