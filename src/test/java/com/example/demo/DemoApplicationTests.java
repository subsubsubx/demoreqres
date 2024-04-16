package com.example.demo;

import dto.*;
import feign.ReqInterceptor;
import feign.UserService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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
        Assert.assertTrue(createUser.getStatusCode().is2xxSuccessful(), "Неуспешный статус код = "
                + createUser.getStatusCode().value());
        int i = 0;
    }


}
