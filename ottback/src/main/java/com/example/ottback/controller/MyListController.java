package com.example.ottback.controller;

import com.example.ottback.DTO.MyListDTO;
import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import com.example.ottback.service.MyListService;
import com.example.ottback.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/mylist")
public class MyListController {
    @Autowired
    MyListService myListService;
    @Autowired
    UserService userService;
    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody MyListDTO myListDTO){
        try {
            User user = userService.findbyId(myListDTO.getUserIndex());
            Mylist myList = Mylist.builder().user(user)
                    .listName(myListDTO.getListName())
                    .authority(myListDTO.isAuthority())
                    .likeCount(0)
                    .build();
            Mylist registerMyList = myListService.save(myList);
            MyListDTO responseDTO = MyListDTO.builder().listIndex(registerMyList.getListIndex())
                    .userIndex(registerMyList.getUser().getUserIndex())
                    .listName(registerMyList.getListName())
                    .authority(registerMyList.isAuthority())
                    .likeCount(registerMyList.getLikeCount())
                    .build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);

        }
    }
    @PostMapping("findopened")
    public ResponseEntity<?> findIsOpen(@RequestBody MyListDTO myListDTO){
        try {
            User user = userService.findbyId(myListDTO.getUserIndex());
            List<Mylist> mylists = myListService.findByOpen(user);
            List<MyListDTO> dtos = mylists.stream().map(MyListDTO::new).collect(Collectors.toList());
            ResponseDTO<Object> responseDTO = ResponseDTO.builder().error("").data(dtos).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
    @PostMapping("findmine")
    public ResponseEntity<?> findMine(@RequestBody MyListDTO myListDTO){
        try {
            User user = userService.findbyId(myListDTO.getUserIndex());
            List<Mylist> mylists = myListService.findMine(user);
            List<MyListDTO> dtos = mylists.stream().map(MyListDTO::new).collect(Collectors.toList());
            ResponseDTO<Object> responseDTO = ResponseDTO.builder().error("").data(dtos).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MyListDTO myListDTO){
        try {
            Mylist mylist = myListService.findByIndex(myListDTO.getListIndex());
            Mylist updateList = myListService.updateList(mylist, myListDTO.getListName(), myListDTO.isAuthority());
            MyListDTO responseDTO = MyListDTO.builder()
                    .listIndex(updateList.getListIndex())
                    .listName(updateList.getListName())
                    .authority(updateList.isAuthority())
                    .userIndex(updateList.getUser().getUserIndex())
                    .build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
}
