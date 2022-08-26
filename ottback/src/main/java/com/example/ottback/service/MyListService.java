package com.example.ottback.service;

import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import com.example.ottback.repository.MyListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MyListService {
    @Autowired
    MyListRepository myListRepository;

    public Mylist save(Mylist myList) {
        inputNull(myList);
        return myListRepository.save(myList);

    }
    private void inputNull(Mylist myList){
        if(myList.getListName().equals("") || myList.getListName() ==null){
            log.error("제목을 입력하지 않음");
            throw new RuntimeException("Invalid title");
        }

    }

    public List<Mylist> findByOpen(User user) {
        if(myListRepository.findByAuthorityAndUserNot(true, user) == null){
            log.error("아직 입력된 데이터가 없습니다.");
            throw new NullPointerException("not input data");
        }
        return myListRepository.findByAuthorityAndUserNot(true, user);
    }
}
