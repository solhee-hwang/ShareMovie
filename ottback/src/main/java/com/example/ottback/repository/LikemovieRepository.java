package com.example.ottback.repository;

import com.example.ottback.model.Likemovie;
import com.example.ottback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikemovieRepository extends JpaRepository<Likemovie, Integer> {
    Optional<Likemovie> findByUserAndMovieId(User user,Integer movieId);

    Boolean existsByUserAndMovieId(User user, Integer movieId);
}
