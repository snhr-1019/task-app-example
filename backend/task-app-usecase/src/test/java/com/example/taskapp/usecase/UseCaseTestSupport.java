package com.example.taskapp.usecase;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest(classes = UseCaseTestSupport.class)
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.example.taskapp")
public class UseCaseTestSupport {
}
