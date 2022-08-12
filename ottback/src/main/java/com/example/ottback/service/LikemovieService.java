package com.example.ottback.service;

import com.example.ottback.model.Likemovie;
import com.example.ottback.repository.LikemovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LikemovieService {
    @Autowired
    private LikemovieRepository likemovieRepository;
    public Likemovie like(Likemovie likemovie) {
        if(likemovieRepository.existsByUserAndMovieId(likemovie.getUser(), likemovie.getMovieId())){
            likemovieRepository.delete(likemovie);
            return null;
        }
        likemovieRepository.save(likemovie);
        return likemovie;
    }
    public List<Likemovie> findAll(){
        return likemovieRepository.findAll();
    }
}
