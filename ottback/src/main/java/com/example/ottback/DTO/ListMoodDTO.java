package com.example.ottback.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListMoodDTO {
    private Long listMoodIndex;
    private Long userIndex;
    private Long listIndex;
    private Long moodIndex;

}
