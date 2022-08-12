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
public class ListMood {
    @Id
    @Column(name="moodgroup_index")
    private Long moodGroupIndex;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mood_index")
    private Mood mood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mylist_index")
    private Mylist myList;


}
