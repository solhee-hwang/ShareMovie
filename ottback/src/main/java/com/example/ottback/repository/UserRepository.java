package com.example.ottback.repository;

import com.example.ottback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);

    Optional<User> findByUserIndex(Long index);


}
