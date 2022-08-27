package com.example.ottback.service;

import com.example.ottback.model.Movie;
import com.example.ottback.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie save(Movie movie) {
        movieIdIsNull(movie.getMovieId());
        return movieRepository.save(movie);

    }
    private void movieIdIsNull(int movieId){
        if(movieId == -1 ) {
            log.error("movieId is null");
            throw new NullPointerException("Invalid movieId");
        }
    }

    public Movie findbyIndex(Long movieIdex) {
        if(movieRepository.findByMovieIndex(movieIdex).isPresent()){
            return movieRepository.findByMovieIndex(movieIdex).get();
        }
        log.error("없는 movieIndex : {}", movieIdex);
        throw new NullPointerException("Invalid movieIndex");
    }

    public Movie delete(Movie movie) {
        movieRepository.delete(movie);
        return movie;
    }
}
