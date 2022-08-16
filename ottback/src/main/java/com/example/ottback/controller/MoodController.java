package com.example.ottback.controller;

import com.example.ottback.DTO.LikemovieDTO;
import com.example.ottback.DTO.MoodDTO;
import com.example.ottback.DTO.ResponseDTO;
import com.example.ottback.model.Mood;
import com.example.ottback.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mood")
@CrossOrigin("*")
public class MoodController {
    @Autowired
    MoodService moodService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MoodDTO moodDTO){
        try {
            Mood mood = Mood.builder().mood(moodDTO.getMood()).build();
            System.out.println(">>>>>>" + moodDTO.getMood());
            System.out.println(mood.getMood());
            Mood registerMood = moodService.save(mood);
            MoodDTO responseDTO = MoodDTO.builder().moodIndex(registerMood.getMoodIndex()).mood(registerMood.getMood()).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }

    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody MoodDTO moodDTO){
        try {
            Mood mood = moodService.findByIndex(moodDTO.getMoodIndex());
            List<Mood> moods = moodService.delete(mood);
            List<MoodDTO> dtos = moods.stream().map(MoodDTO::new).collect(Collectors.toList());
            ResponseDTO<Object> responseDTO = ResponseDTO.builder().error("").data(dtos).build();
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
