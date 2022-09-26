package com.example.ottback.model;

import com.example.ottback.repository.FriendsRepository;
import com.example.ottback.repository.UserRepository;
import com.example.ottback.service.FriendsService;
import com.example.ottback.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FriendsTest {
    @Autowired
    UserService userService;
    @Autowired
    FriendsService friendsService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FriendsRepository friendsRepository;

    @Test
    public void 저장(){

    }
}
