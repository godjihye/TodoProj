package com.jhshin.todoproj.service;

import com.jhshin.todoproj.model.TodoEntity;
import com.jhshin.todoproj.persistence.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
//    public String testService() {
//        return "Test Service";
//    }
    @Autowired
    private TodoRepository repository;
    public String testService() {
        TodoEntity entity = TodoEntity.builder().title("My First Todo Item").build();
        repository.save(entity);
        TodoEntity savedEntity = repository.findById(entity.getId()).get();
        return savedEntity.getTitle();
    }

}
