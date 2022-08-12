package com.example.ottback.repository;

import com.example.ottback.model.Likemovie;
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
public class LikemovieRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LikemovieRepository likemovieRepository;
    @Test
    public void 복합키_적용(){
        System.out.println(likemovieRepository.findAll());
    }
    @Test
    void 저장(){
        User user = User.builder()
                .email("user1")
                .userId("user1")
                .password("1234")
                .build();
        userRepository.save(user);
        Likemovie likemovie = Likemovie.builder()
                .user(user).movieId(1).build();
        Likemovie result =likemovieRepository.save(likemovie);
        assertThat(result).isEqualTo(likemovieRepository.findAll().get(0));
    }
    @Test
    void 좋아요찾기(){
        User user = User.builder()
                .email("user1")
                .userId("user1")
                .password("1234")
                .build();
        userRepository.save(user);
        Likemovie likemovie1 = Likemovie.builder()
                .movieId(1).user(user).build();
        Likemovie likemovie2 = Likemovie.builder()
                .movieId(2).user(user).build();
        likemovieRepository.save(likemovie1);
        likemovieRepository.save(likemovie2);

        Likemovie result =likemovieRepository.findByUserAndMovieId(user, 2).get();
        assertThat(likemovieRepository.findAll().get(1)).isEqualTo(result);
    }
}
