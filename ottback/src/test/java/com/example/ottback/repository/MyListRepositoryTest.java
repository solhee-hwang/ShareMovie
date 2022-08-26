package com.example.ottback.repository;

import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MyListRepositoryTest {
    @Autowired
    MyListRepository myListRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void 공개된_리스트들_유저제외(){
        User user1 = User.builder()
                .email("user1")
                .userId("user1")
                .password("1234")
                .build();
        User user2 = User.builder()
                .email("user2")
                .userId("user2")
                .password("1234")
                .build();
        User user3 = User.builder()
                .email("user3")
                .userId("user3")
                .password("1234")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Mylist mylist1 = Mylist.builder().authority(false).listName("name1").user(user1).build();
        Mylist mylist2 = Mylist.builder().authority(true).listName("name2").user(user2).build();
        Mylist mylist3 = Mylist.builder().authority(true).listName("name3").user(user1).build();
        Mylist mylist4 = Mylist.builder().authority(true).listName("name3").user(user3).build();
        Mylist mylist5 = Mylist.builder().authority(false).listName("name3").user(user3).build();
        myListRepository.save(mylist1);
        myListRepository.save(mylist2);
        myListRepository.save(mylist3);
        myListRepository.save(mylist4);
        myListRepository.save(mylist5);

        List<Mylist> result = myListRepository.findByAuthorityAndUserNot(true, user2);
        List<Mylist> answer = new ArrayList<>();
        answer.add(mylist3);
        answer.add(mylist4);
        assertThat(result).isEqualTo(answer);
    }

}