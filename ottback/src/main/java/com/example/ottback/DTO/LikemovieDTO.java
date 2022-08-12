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
    private int movieId;
    private Long userIndex;

    public LikemovieDTO(final Likemovie likemovie) {
        this.movieId = likemovie.getMovieId();
        this.userIndex = likemovie.getUser().getUserIndex();
    }
}
