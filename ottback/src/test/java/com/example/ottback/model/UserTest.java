package com.example.ottback.model;

import com.example.ottback.repository.UserRepository;
import com.example.ottback.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Test
    public void BaseTimeEntity_등록(){
        LocalDateTime now = LocalDateTime.now();
        User user = User.builder()
                .email("user1")
                .userId("user2")
                .password("1234")
                .build();
        userService.save(user);
        List<User> userList = userRepository.findAll();
        User result = userList.get(0);

        System.out.println("createDate= " + result.getCreatedDate() + ", modigiedDate=" + result.getModifiedDate());
//
        assertThat(user.getCreatedDate()).isAfter(now);
        assertThat(user.getModifiedDate()).isAfter(now);


    }
}
