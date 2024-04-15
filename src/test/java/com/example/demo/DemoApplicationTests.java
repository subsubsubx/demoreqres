package com.example.demo;

import dto.*;
import feign.ReqInterceptor;
import feign.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserService userService;


    @Test
    void contextLoads() throws IOException {
  //     ResponseEntity<UserDto> user = userService.getUser(2);
    //   ResponseEntity<UsersDto> users = userService.getUsers(2);
ResponseEntity<NewUserResponse> createUser = userService.postUser(NewUser.builder().job("kal").name("John").build());

        int i = 0;
    }


}
