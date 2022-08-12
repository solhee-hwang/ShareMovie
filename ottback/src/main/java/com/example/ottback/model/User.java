package com.example.ottback.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_index")
    private Long userIndex;

    @Column(name="user_id")
    private String userId;

    @Column(name="user_password")
    private String password;

    @Column(name="user_email")
    private String email;



}
