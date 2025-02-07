package com.jhshin.todoproj.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {
    private String error;
    private List<T> data; // Todo를 리스트로 반환하는 경우가 많기 때문
}
