package com.example.ottback.service;

import com.example.ottback.model.ListMood;
import com.example.ottback.repository.ListMoodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ListMoodService {
    @Autowired
    ListMoodRepository listMoodRepository;

    public ListMood save(ListMood listMood) {
        validateDuplicateListMood(listMood);
        return listMoodRepository.save(listMood);
    }
    private void validateDuplicateListMood(ListMood listMood){
        listMoodRepository.findByMyListAndMood(listMood.getMyList(),listMood.getMood())
                .ifPresent(m->{
                        log.warn("listmoodIndex : {} 이미 존재", m.getListMoodIndex());
                        throw new IllegalStateException("listMood already exists");}
                );
    }
    public ListMood findByIndex(Long index){
        ListMood listMood = listMoodRepository.findByListMoodIndex(index).orElseThrow(
                () -> new IllegalArgumentException("해당 인덱스에 포함하는 listmood 가 없다, Index : " +  index)
        );
        return listMood;
    }

    public List<ListMood> delete(ListMood listMood) {
        listMoodRepository.delete(listMood);
        return listMoodRepository.findAll();
    }
}
