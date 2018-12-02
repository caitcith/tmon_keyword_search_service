package com.tmon.search.keyword.service;


import com.tmon.search.keyword.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordEncoderTest {
    @Autowired
    UserDetailsSecurityService userService;
    @Test
    public void test() {
        String username = "test1";
        String password = "testpassword";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        User savedUser = userService.saveUser(user);

        log.info("{}", savedUser);
    }
}