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
public class Likemovie extends BaseTimeEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="likemovie_index")
    private Long likemovieIndex;

    @Column(name ="movieId")
    private int movieId;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_index")
    private User user;


}
