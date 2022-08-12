package com.example.ottback.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="list_index")
    private Long listIndex;

    @Column(name="list_name")
    private String listName;

    @Column(name="movie_id")
    private int movieId;

    @Column(name="authority")
    private boolean authority;

    @Column(name="like_count")
    private int likeCount;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_index")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "myList")
    private Set<ListMood> moods = new HashSet<>();

}
