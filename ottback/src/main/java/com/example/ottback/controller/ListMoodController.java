package com.example.ottback.controller;

import com.example.ottback.DTO.ListMoodDTO;
import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.model.*;
import com.example.ottback.service.ListMoodService;
import com.example.ottback.service.MoodService;
import com.example.ottback.service.MyListService;
import com.example.ottback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/listmood")
@CrossOrigin("*")
public class ListMoodController extends BaseTimeEntity {
    @Autowired
    ListMoodService listMoodService;
    @Autowired
    UserService userService;
    @Autowired
    MoodService moodService;
    @Autowired
    MyListService myListService;
    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody ListMoodDTO listMoodDTO ){
        try {
            Mood mood = moodService.findByIndex(listMoodDTO.getMoodIndex());
            Mylist mylist = myListService.findByIndex(listMoodDTO.getListIndex());
            ListMood listMood = ListMood.builder().myList(mylist).mood(mood).build();
            ListMood registerListMood = listMoodService.save(listMood);
            ListMoodDTO reponseDTO = ListMoodDTO.builder().listMoodIndex(registerListMood.getListMoodIndex())
                    .moodIndex(registerListMood.getMood().getMoodIndex())
                    .listIndex(registerListMood.getMyList().getListIndex()).build();
            return ResponseEntity.ok(reponseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

}
