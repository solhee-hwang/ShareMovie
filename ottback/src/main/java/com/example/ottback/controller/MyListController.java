package com.example.ottback.controller;

import com.example.ottback.DTO.MyListDTO;
import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import com.example.ottback.service.MyListService;
import com.example.ottback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mylist")
@CrossOrigin("*")
public class MyListController {
    @Autowired
    MyListService myListService;
    @Autowired
    UserService userService;
//    @PostMapping("save")
//    public ResponseEntity<?> save(MyListDTO myListDTO){
//        User user = userService.findbyId(myListDTO.getUserIndex());
//        Mylist myList = Mylist.builder().user(user)
//                .listName(myListDTO.getListName())
//                .authority(myListDTO.isAuthority())
//                .likeCount(myListDTO.getLikeCount())
//                .movieId(myListDTO.getMovieId())
//                .build();
//        Mylist registerMyList = myListService.save(myList);
//    }


}
