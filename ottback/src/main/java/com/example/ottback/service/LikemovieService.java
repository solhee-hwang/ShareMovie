package com.example.ottback.service;

import com.example.ottback.model.Likemovie;
import com.example.ottback.repository.LikemovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LikemovieService {
//    @Autowired
//    private LikemovieRepository likemovieRepository;
//    public Likemovie like(Likemovie likemovie) {
//        likemovieRepository.findByMovieIdAndUser(likemovie.getMovieId(), likemovie.getUser())
//                .ifPresent(m-> {
//                    log.info("좋아요 취소");
//                    likemovieRepository.delete(likemovie);
//                    return ;}
//                );
//        likemovieRepository.save(likemovie);
//        return likemovie;
//    }
}
