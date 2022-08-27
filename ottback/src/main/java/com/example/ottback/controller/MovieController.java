package com.example.ottback.controller;

import com.example.ottback.DTO.MovieDTO;
import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.model.Movie;
import com.example.ottback.model.Mylist;
import com.example.ottback.service.MovieService;
import com.example.ottback.service.MyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@CrossOrigin("*")
public class MovieController {
    @Autowired
    MovieService movieService;
    @Autowired
    MyListService myListService;

    @GetMapping("save")
    public ResponseEntity<?> save(
            @RequestParam(value = "listIndex") Long listIndex,
            @RequestParam(value = "movieId", defaultValue = "-1")int movieId){
        try {
            Mylist mylist = myListService.findByIndex(listIndex);
            Movie movie = Movie.builder().movieId(movieId).myList(mylist).build();
            Movie registerMovie = movieService.save(movie);
            MovieDTO responseDTO = MovieDTO.builder().movieId(registerMovie.getMovieId()).movieIndex(registerMovie.getMovieIndex()).listIndex(registerMovie.getMyList().getListIndex()).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
    //list내 영화들을 편집하기 위함
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam(value = "movieIndex") Long movieIdex){
        try {
            Movie movie = movieService.findbyIndex(movieIdex);
            Movie registerMovie = movieService.delete(movie);
            MovieDTO responseDTO = MovieDTO.builder().movieId(registerMovie.getMovieId()).movieIndex(registerMovie.getMovieIndex()).listIndex(registerMovie.getMyList().getListIndex()).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
