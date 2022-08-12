package com.example.ottback.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Likelist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="likelist_index")
    private Long likeListIndex;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "user_index")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MyList.class)
    @JoinColumn(name="list_index")
    private MyList myList;

}
