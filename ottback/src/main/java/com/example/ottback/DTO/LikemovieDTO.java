package com.example.ottback.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LikemovieDTO {
    private int movieId;
    private Long userIndex;

}
