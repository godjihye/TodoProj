package com.jhshin.todoproj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator="system-uuid") // ID 자동생성
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String id;
    private String title;
    private String userId;
    private boolean done;
}
