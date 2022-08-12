package com.example.ottback.repository;

import com.example.ottback.model.Mylist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyListRepository extends JpaRepository<Mylist,Long> {
}
