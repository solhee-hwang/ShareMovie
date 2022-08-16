package com.example.ottback.service;

import com.example.ottback.model.Mood;
import com.example.ottback.repository.MoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MoodService {
    @Autowired
    MoodRepository moodRepository;

    public Mood save(Mood mood) {
        if(mood.getMood().equals("") || mood.getMood() ==null){
            log.error("mood 값 null");
            throw new RuntimeException("Invalid mood");
        }
        validateDuplicateMood(mood);
        return moodRepository.save(mood);
    }
    private void validateDuplicateMood(Mood mood){
        moodRepository.findByMood(mood.getMood())
                .ifPresent(m->{
                    log.error("중복된 mood : {} ", mood.getMood());
                    throw new IllegalStateException("Mood already exists");
                });
    }

    public List<Mood> delete(Mood mood) {
        moodRepository.delete(mood);
        return moodRepository.findAll();
    }

    public Mood findByIndex(Long moodIndex) {
        return moodRepository.findByMoodIndex(moodIndex).get();
    }
}
