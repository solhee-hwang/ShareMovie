package com.example.ottback.service;

import com.example.ottback.model.User;
import com.example.ottback.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    public void save() {
        //given
        User user = User.builder()
                .userId("user1").email("user1").password("1234").build();
        User user2 = User.builder().userId("user1").email("user2").password("1234").build();
        when(userRepository.save(user)).thenReturn(user);
        //when
        userService.save(user);
        //then
//        User result = userRepository.findAll().get(0);
        assertThat(user).isEqualTo(userService.save(user));
//        assertThat(user2).isEqualTo(result);
        //
    }

    @Test
    public void index로_찾기(){
        Long index = 1L;
        User user = User.builder()
                .userId("user1").email("user1").password("1234").build();
        when(userRepository.findByUserIndex(index)).thenReturn(Optional.ofNullable(user));
//        when(userRepository.findByUserIndex(2L)).thenReturn(null);
        User resposeUser = userService.findbyIndex(1L);
        assertThat(user).isEqualTo(resposeUser);
    }

}
