package com.example.ottback.repository;

import com.example.ottback.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void save(){
        User user = User.builder()
                .email("user1")
                .userId("user1")
                .password("1234")
                .build();
        userRepository.save(user);
        User result = userRepository.findByUserId(user.getUserId()).get();
        assertThat(user).isEqualTo(result);
    }
    @Test
    public void findByUserId(){
        User user1 = User.builder()
                .email("user1")
                .userId("user1")
                .password("1234")
                .build();
        userRepository.save(user1);
        System.out.println(">>>>>>>>>>>>>>>>>createDate= " + user1.getCreatedDate() + ", modigiedDate=" + user1.getModifiedDate());
        User user2 = User.builder()
                .email("user2")
                .userId("user2")
                .password("1234")
                .build();
        userRepository.save(user2);
        User result = userRepository.findByUserId("user1").get();
        assertThat(result).isEqualTo(user1);

    }
    @Test
    public void index로_찾기(){
        User user1 = User.builder().email("user1").userId("user1").password("1234").build();
        User user2 = User.builder().email("user2").userId("user2").password("1234").build();
        userRepository.save(user1);
        userRepository.save(user2);
        Long resultindex = userRepository.findByUserId("user1").get().getUserIndex();
        User user = userRepository.findByUserIndex(resultindex).get();
        assertThat(user1).isEqualTo(user);
    }

}
