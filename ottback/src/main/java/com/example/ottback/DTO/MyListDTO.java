package com.example.ottback.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyListDTO {
    private Long userIndex;
    private String listName;
    private String mood;
    private int movieId;
    private boolean authority;
    private int likeCount;
}
