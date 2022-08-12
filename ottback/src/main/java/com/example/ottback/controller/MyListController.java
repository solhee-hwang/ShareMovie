package com.example.ottback.controller;

import com.example.ottback.service.MyListService;
import com.example.ottback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//                .listMood(myListDTO.getMood())
//                .listName(myListDTO.getListName())
//                .authority(myListDTO.isAuthority())
//                .likeCount(myListDTO.getLikeCount())
//                .movieId(myListDTO.getMovieId())
//                .build();
//        Mylist registerMyList = myListService.save(myList);
//    }


}
