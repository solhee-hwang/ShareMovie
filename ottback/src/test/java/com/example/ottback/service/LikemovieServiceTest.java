package com.example.ottback.service;

import com.example.ottback.model.Likemovie;
import com.example.ottback.model.User;
import com.example.ottback.repository.LikemovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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
                .user(user).movieId(1).build();
        when(likemovieRepository.existsByUserAndMovieId(any(),anyInt())).thenReturn(false);
        when(likemovieRepository.save(any())).thenReturn(likemovie);
        assertThat(likemovieService.like(likemovie)).isEqualTo(likemovie);
    }

}