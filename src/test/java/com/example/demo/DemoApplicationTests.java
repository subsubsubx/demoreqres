package com.example.demo;

import dto.user.NewUserDto;
import dto.user.UserDto;
import dto.user.UsersDto;
import feign.api.UserService;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private UserService userService;


    @Test
    @DisplayName("Назовите имя")
    @Description("Описание")
    void test1() throws IOException {
        ResponseEntity<UserDto> user = userService.getUser(2);


    }

    @Test
    void test2() {
        ResponseEntity<UsersDto> users = userService.getUsers(2);

    }


    @Test
    void test3() {
        ResponseEntity<NewUserDto> createUser = userService.postUser(NewUserDto.builder().job("kal").name("John").build());
        Assert.assertTrue(createUser.getStatusCode().is2xxSuccessful(), "Неуспешный статус код = "
                + createUser.getStatusCode().value());
    }
}
