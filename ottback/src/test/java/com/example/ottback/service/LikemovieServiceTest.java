package com.example.ottback.service;

import com.example.ottback.model.Likemovie;
import com.example.ottback.model.User;
import com.example.ottback.repository.LikemovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LikemovieServiceTest {
    @Mock
    LikemovieRepository likemovieRepository;
    @InjectMocks
    LikemovieService likemovieService;
    @Test
    void 좋아요(){
        User user = User.builder()
                .email("user1")
                .userId("user1")
                .password("1234")
                .build();
        Likemovie likemovie = Likemovie.builder()
                .user(user).likemovieIndex(1L).build();
        when(likemovieRepository.existsByUserAndLikemovieIndex(any(),anyLong())).thenReturn(false);
        when(likemovieRepository.save(any())).thenReturn(likemovie);
        assertThat(likemovieService.like(likemovie)).isEqualTo(likemovie);
    }

}