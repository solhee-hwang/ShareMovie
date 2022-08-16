package com.example.ottback.DTO;

import com.example.ottback.model.Mood;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MoodDTO {
    private Long moodIndex;
    private String mood;

    public MoodDTO(final Mood mood){
        this.moodIndex = mood.getMoodIndex();
        this.mood = mood.getMood();
    }
}
