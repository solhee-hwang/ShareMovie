package com.example.ottback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mood {
    @Id
    @Column(name = "mood_index")
    private Long moodIndex;

    @Column(name = "mood")
    private String mood;


}
