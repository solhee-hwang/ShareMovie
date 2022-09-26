package com.example.ottback.service;

import com.example.ottback.model.Friends;
import com.example.ottback.model.User;
import com.example.ottback.repository.FriendsRepository;
import com.example.ottback.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FriendsService {
    @Autowired
    FriendsRepository friendsRepository;
    @Autowired
    UserRepository userRepository;

    public Friends save(Friends friends) {
        userRepository.findByUserIndex(friends.getFriendUserIndex()).orElseThrow(
                () -> new IllegalArgumentException("해당 user 없음" + friends.getFriendUserIndex())
        );
        return friendsRepository.save(friends);
    }
}
