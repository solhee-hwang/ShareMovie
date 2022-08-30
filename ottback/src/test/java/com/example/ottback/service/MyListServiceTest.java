package com.example.ottback.service;

import com.example.ottback.model.Mylist;
import com.example.ottback.repository.MyListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyListServiceTest {
    @Mock
    MyListRepository myListRepository;

    @InjectMocks
    MyListService myListService;
    @Test
    void update(){
        Mylist original = Mylist.builder().listIndex(1L).listName("name1").authority(true).build();
        Mylist newList = Mylist.builder().listIndex(1L).listName("name2").authority(true).build();
        when(myListRepository.save(any())).thenReturn(newList);
        Mylist result = myListService.updateList(original,"name2",true);


    }
}
