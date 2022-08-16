package com.example.ottback.controller;

import com.example.ottback.DTO.LikemovieDTO;
import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.model.Likemovie;
import com.example.ottback.model.User;
import com.example.ottback.service.LikemovieService;
import com.example.ottback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        try {
            User user = userService.findbyId(likemovieDTO.getUserIndex());
            Likemovie likemovie = Likemovie.builder()
                    .movieId(likemovieDTO.getMovieId())
                    .user(user).build();
            Likemovie registerLikemovie = likemovieService.like(likemovie);

            if(registerLikemovie != null){
                LikemovieDTO responseDTO = LikemovieDTO.builder().movieId(registerLikemovie.getMovieId())
                    .userIndex(registerLikemovie.getUser().getUserIndex())
                    .build();
            return ResponseEntity.ok(responseDTO);
            }
            List<Likemovie> likemovies = likemovieService.findAll();
            List<LikemovieDTO> dtos = likemovies.stream().map(LikemovieDTO::new).collect(Collectors.toList());
            ResponseDTO<LikemovieDTO> responseDTO = ResponseDTO.<LikemovieDTO>builder().data(dtos).error("").build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
