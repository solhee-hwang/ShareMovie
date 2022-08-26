package com.example.ottback.repository;

import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyListRepository extends JpaRepository<Mylist,Long> {
    List<Mylist> findByAuthorityAndUserNot(Boolean authority, User user);
}
