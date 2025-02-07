package com.jhshin.todoproj.persistence;

import com.jhshin.todoproj.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    List<TodoEntity> findByUserId(String userId);
//    @Query("select t.id, t.title, t.userId, t.done from TodoEntity t where t.userId = ?1")
//    List<TodoEntity> findByUserIdQuery(String userId);
}
