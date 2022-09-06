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
        if(likemovieRepository.findByUserAndMovieId(likemovie.getUser(), likemovie.getMovieId())!= null){
            likemovie = likemovieRepository.findByUserAndMovieId(likemovie.getUser(), likemovie.getMovieId());
            log.info("좋아요 취소");
            likemovieRepository.delete(likemovie);
            return likemovie;
        }
        return likemovieRepository.save(likemovie);
    }
    public List<Likemovie> findAll(){
        return likemovieRepository.findAll();
    }
}
