package com.example.ottback.controller;

import com.example.ottback.DTO.LikeListDTO;
import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.model.Likelist;
import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import com.example.ottback.service.LikeListService;
import com.example.ottback.service.MyListService;
import com.example.ottback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/likelist")
public class LikeListController {
    @Autowired
    LikeListService likeListService;
    @Autowired
    UserService userService;
    @Autowired
    MyListService myListService;
    @PostMapping()
    public ResponseEntity<?> like(@RequestBody LikeListDTO likeListDTO) {
        try {
            User user = userService.findbyIndex(likeListDTO.getUserIndex());
            Mylist mylist = myListService.findByIndex(likeListDTO.getListIndex());
            Likelist likelist = Likelist.builder().user(user).myList(mylist).build();
            Likelist registerLikelist = likeListService.like(likelist);
            LikeListDTO reponseDTO = LikeListDTO.builder().listIndex(registerLikelist.getMyList().getListIndex())
                    .userIndex(registerLikelist.getUser().getUserIndex())
                    .likeCounts(registerLikelist.getMyList().getLikeCount()).build();
            return ResponseEntity.ok(reponseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
}
