package com.example.ottback.repository;

import com.example.ottback.model.Likelist;
import com.example.ottback.model.Mylist;
import com.example.ottback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeListRepository extends JpaRepository<Likelist, Long> {
    Likelist findByUserAndMyList(User user, Mylist mylist);
}
