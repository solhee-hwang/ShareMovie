package com.example.ottback.service;

import lombok.extern.slf4j.Slf4j;
import com.example.ottback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ottback.repository.UserRepository;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User save(User user) {
        emailOrIdIsNull(user.getEmail(), user.getUserId());
        validateDuplicateUser(user);
        return userRepository.save(user);
    }
    public User findbyIndex(Long userIndex){
        if(userRepository.findByUserIndex(userIndex).isPresent()){
            return userRepository.findByUserIndex(userIndex).get();
        }
        log.error("없는 유저 , index : {}", userIndex);
        throw new NullPointerException("Invalid userIndex");
    }


    private void emailOrIdIsNull(String email, String userID) {
        if(email.equals("") || email==null ) {
            log.error("이메일을 입력하지 않음");
            throw new RuntimeException("Invalid email");
        }
        if(userID.equals("") || userID==null){
            log.error("아이디를 입력하지 않음");
            throw new RuntimeException("Invalid userId");
        }
    }
    private void validateDuplicateUser(User user) {
        userRepository.findByEmail(user.getEmail())
                .ifPresent(m-> {
                    log.error("이메일 중복, email : {}",user.getEmail());
                    throw new IllegalStateException("Email already exists");
                });
        userRepository.findByUserId(user.getUserId())
                .ifPresent(m -> {
                    log.error("아이디 중복, ID : {}", user.getUserId());
                    throw new IllegalStateException("UserId already exists");
                });
    }


}
