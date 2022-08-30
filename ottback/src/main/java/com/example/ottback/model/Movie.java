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
public class Movie extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_index")
    private Long movieIndex;

    @Column(name="movie_Id")
    private int movieId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Mylist.class)
    @JoinColumn(name = "list_index")
    private Mylist myList;
}
