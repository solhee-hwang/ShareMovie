package com.example.ottback.service;

import com.example.ottback.model.Mylist;
import com.example.ottback.repository.MyListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class MyListService {
    @Autowired
    MyListRepository myListRepository;

//    public Mylist save(Mylist myList) {
//        inputNull(myList);
//
//    }
    private void inputNull(Mylist myList){
        if(myList.getListName().equals("") || myList.getListName() ==null){
            log.error("제목을 입력하지 않음");
            throw new RuntimeException("Invalid title");
        }

    }
}
