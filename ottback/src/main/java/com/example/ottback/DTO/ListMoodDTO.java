package com.example.ottback.DTO;

import com.example.ottback.model.ListMood;
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
    private Long listIndex;
    private Long moodIndex;

    public ListMoodDTO(final ListMood listMood){
        this.listMoodIndex = listMood.getListMoodIndex();
        this.listIndex = listMood.getMyList().getListIndex();
        this.moodIndex = listMood.getMood().getMoodIndex();
    }

}
