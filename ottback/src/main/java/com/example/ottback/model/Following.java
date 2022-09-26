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
public class Following extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "following_index")
    private Long followingIndex;

    @Column(name = "following_user")
    private Long followingUserIndex;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_index")
    private User user;
}
