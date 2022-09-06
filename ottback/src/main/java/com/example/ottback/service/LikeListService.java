package com.example.ottback.service;

import com.example.ottback.model.Likelist;
import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import com.example.ottback.repository.LikeListRepository;
import com.example.ottback.repository.MyListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LikeListService {
    @Autowired
    LikeListRepository likeListRepository;
    @Autowired
    MyListRepository myListRepository;

    public Likelist like(Likelist likelist) {
        User user = likelist.getUser();
        Mylist mylist = likelist.getMyList();
        if(likeListRepository.findByUserAndMyList(user, mylist) != null){
            likelist = likeListRepository.findByUserAndMyList(user, mylist);
            log.info(("좋아요 취소"));
            mylist.unlike();
            myListRepository.save(mylist);
            likeListRepository.delete(likelist);
            return likelist;
        }
        if(mylist.isAuthority() == true){
            log.warn("{},  게시물은 비공계이다",mylist.getListIndex());
            throw new RuntimeException("priavate list ");
        }
        mylist.likes();
        log.info("좋아요");
        myListRepository.save(mylist);
        return likeListRepository.save(likelist);
    }
}
