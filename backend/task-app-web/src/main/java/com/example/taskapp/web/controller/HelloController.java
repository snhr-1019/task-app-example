package com.example.taskapp.web.controller;

import gen.openapi.taskapp.api.HelloApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController implements HelloApi {

    @Override
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello, world", HttpStatus.OK);
    }
}
