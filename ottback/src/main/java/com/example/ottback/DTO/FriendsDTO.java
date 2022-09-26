package com.example.ottback.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendsDTO {
    private Long friendsIndex;
    private Long userIndex;
    private Long friendUserIndex;

}
