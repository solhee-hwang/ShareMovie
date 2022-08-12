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
    @Column(name ="movie_id")
    private Integer movieId;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_index")
    private User user;


}
