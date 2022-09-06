package com.example.ottback.repository;

import com.example.ottback.model.ListMood;
import com.example.ottback.model.Mood;
import com.example.ottback.model.Mylist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListMoodRepository extends JpaRepository<ListMood, Long> {
    Optional<ListMood> findByMyListAndMood(Mylist mylist, Mood mood);
}
