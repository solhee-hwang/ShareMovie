package com.example.ottback.repository;

import com.example.ottback.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface MoodRepository extends JpaRepository<Mood, Long> {
    Optional<Mood> findByMood(String mood);
}
