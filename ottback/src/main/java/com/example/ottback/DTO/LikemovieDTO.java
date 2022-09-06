package com.example.ottback.DTO;

import com.example.ottback.model.Likemovie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikemovieDTO {
    private Long likemovieIndex;
    private Long userIndex;
    private int movieId;

    public LikemovieDTO(final Likemovie likemovie) {
        this.likemovieIndex = likemovie.getLikemovieIndex();
        this.userIndex = likemovie.getUser().getUserIndex();
        this.movieId = likemovie.getMovieId();
    }
}
