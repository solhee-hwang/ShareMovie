package com.example.ottback.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Likemovieinfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="likemovieinfo_index")
    private Long likemovieInfoIndex;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Likemovie likemovie;


}
