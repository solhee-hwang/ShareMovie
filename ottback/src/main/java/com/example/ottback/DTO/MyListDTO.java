package com.example.ottback.DTO;

import com.example.ottback.model.ListMood;
import com.example.ottback.model.Mylist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyListDTO {
    private Long userIndex;
    private Long listIndex;
    private String listName;
    private String mood;
    private boolean authority;
    private int likeCount;
    private Set<Long> listMoods;

    public MyListDTO(final Mylist mylist) {
        this.userIndex = mylist.getUser().getUserIndex();
        this.listIndex = mylist.getListIndex();
        this.listName = mylist.getListName();
        this.authority = mylist.isAuthority();
        this.likeCount = mylist.getLikeCount();
    }
}
