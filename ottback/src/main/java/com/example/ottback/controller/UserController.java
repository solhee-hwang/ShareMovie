package com.example.ottback.controller;

import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.DTO.UserDTO;
import com.example.ottback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ottback.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO){
        try{
            User user = User.builder()
                    .email(userDTO.getEmail())
                    .userId(userDTO.getUserId())
                    .password(userDTO.getPassword())
                    .build();
            User registerUser = userService.save(user);
            UserDTO responseDTO = UserDTO.builder()
                    .userIndex(registerUser.getUserIndex())
                    .userId(registerUser.getUserId())
                    .email(registerUser.getEmail())
                    .password(registerUser.getPassword())
                    .build();
            return ResponseEntity.ok(responseDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
