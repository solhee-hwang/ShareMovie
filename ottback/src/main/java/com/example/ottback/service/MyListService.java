package com.example.ottback.service;

import com.example.ottback.DTO.MyListDTO;
import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import com.example.ottback.repository.MyListRepository;
import com.example.ottback.repository.UserRepository;
import lombok.Builder;
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

    public List<Mylist> findMine(User user) {
        if(myListRepository.findByUser(user) == null){
            log.error("아직입력된 데이터가 없습니다");
            throw new NullPointerException("not input data");
        }
        return myListRepository.findByUser(user);
    }
    public Mylist findByIndex(Long listIndex){
        Mylist myList = myListRepository.findByListIndex(listIndex).orElseThrow(
                () -> new IllegalArgumentException("해당 인덱스에 포함하는 list가 없다, Index : " + listIndex));
        return myList;
    }

    public Mylist updateList(Mylist mylist, String listName, Boolean authority) {
        if(listName == null){
            log.warn("제목이 없습니다.");
            throw new IllegalArgumentException("Invalid argument");
        }
        mylist.update(listName, authority);
        return myListRepository.save(mylist);
    }
}
