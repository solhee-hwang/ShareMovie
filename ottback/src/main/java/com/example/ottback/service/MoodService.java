package com.example.ottback.service;

import com.example.ottback.model.Mood;
import com.example.ottback.repository.MoodRepository;
import com.example.ottback.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MoodService {
    @Autowired
    MoodRepository moodRepository;

    public Mood save(Mood mood) {
//        if(mood.getMood().equals("") || mood.getMood() ==null){
//            log.error("mood 값 null");
//            throw new RuntimeException("Invalid mood");
//        }
//        validateDuplicateMood(mood);
        return moodRepository.save(mood);
    }
    private void validateDuplicateMood(Mood mood){
        moodRepository.findByMood(mood.getMood())
                .ifPresent(m->{
                    log.error("중복된 mood : {} ", mood.getMood());
                    throw new IllegalStateException("Mood already exists");
                });
    }
}
