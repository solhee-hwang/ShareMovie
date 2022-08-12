package com.example.ottback.controller;

import com.example.ottback.DTO.LikemovieDTO;
import com.example.ottback.model.Likemovie;
import com.example.ottback.model.User;
import com.example.ottback.service.LikemovieService;
import com.example.ottback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likemovie")
@CrossOrigin("*")
public class LikemovieController {
    @Autowired
    LikemovieService likemovieService;
    @Autowired
    UserService userService;
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody LikemovieDTO likemovieDTO){
        User user = userService.findbyId(likemovieDTO.getUserIndex());
//        Likemovie likemovie = Likemovie.builder()
//                .movieId(likemovieDTO.getMovieId())
//                .user(user).build();
//        Likemovie registerLikemovie = likemovieService.like(likemovie);
        return null;
    }
}
