package com.example.ottback.controller;

import com.example.ottback.DTO.FriendsDTO;
import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.model.Friends;
import com.example.ottback.model.User;
import com.example.ottback.service.FriendsService;
import com.example.ottback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
@CrossOrigin("*")
public class FriendsController {
    @Autowired
    FriendsService friendsService;
    @Autowired
    UserService userService;
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FriendsDTO friendsDTO){
        try {
            User user = userService.findbyIndex(friendsDTO.getUserIndex());
            Friends friends = Friends.builder().friendsIndex(friendsDTO.getFriendsIndex())
                    .friendUserIndex(friendsDTO.getFriendUserIndex())
                    .user(user).build();
            Friends registerdFriends = friendsService.save(friends);
            FriendsDTO responseDTO = FriendsDTO.builder().friendsIndex(registerdFriends.getFriendsIndex())
                    .friendUserIndex(registerdFriends.getFriendUserIndex())
                    .userIndex(registerdFriends.getUser().getUserIndex()).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
