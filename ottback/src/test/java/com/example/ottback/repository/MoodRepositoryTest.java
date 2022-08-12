package com.example.ottback.repository;

import com.example.ottback.model.Mood;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MoodRepositoryTest {
    @Autowired
    MoodRepository moodRepository;
    @Test
    void 저장(){
        Mood mood = Mood.builder().mood("happy").build();
        moodRepository.save(mood);
        assertThat(mood).isEqualTo(moodRepository.findAll().get(0));
    }
    @Test
    void 찾기(){
        Mood mood = Mood.builder().mood("happy").build();
        Mood mood2 = Mood.builder().mood("hap").build();
        moodRepository.save(mood);
        moodRepository.save(mood2);
        Mood result = moodRepository.findByMood("happy").get();
        assertThat(moodRepository.findAll().get(0)).isEqualTo(result);

    }

}