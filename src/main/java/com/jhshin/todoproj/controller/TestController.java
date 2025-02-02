package com.jhshin.todoproj.controller;

import com.jhshin.todoproj.dto.ResponseDTO;
import com.jhshin.todoproj.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    // GetMapping
    @GetMapping
    public String testController() {
        return "Hello World!";
    }
    // GetMapping - URI Path
    @GetMapping("/testGetMapping")
    public String testControllerWithPath() {
        return "Hello World! testGetMapping";
    }
    // GetMapping - Path Variables
    @GetMapping("/{id}")
    public String testControllerWithPathVariable(@PathVariable(required = false) int id) {
        return "Hello World! testGetMapping with id: " + id;
    }
    // GetMapping - Request Parameters
    @GetMapping("/testRequestParams")
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello World ! ID " + id;
    }
    // GetMapping - Request Body
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! ID" + testRequestBodyDTO.getId() + "message" + testRequestBodyDTO.getMessage();
    }
    // GetMapping - Response Body
    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    //GetMapping - ResponseEntity
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And you got 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // return ResponseEntity.badRequest().body(response);
        return ResponseEntity.ok().body(response);
    }
}
