package com.example.demo;

import dto.user.NewUserDto;
import dto.user.UserDto;
import dto.user.UsersDto;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;

import java.io.IOException;

import static util.CustomAssertions.assertCodeSuccessful;

@SpringBootTest
class UserServiceTest extends BaseTest{

    @Test
    @DisplayName("Назовите имя")
    @Description("Описание")
    void test1() throws IOException {
        ResponseEntity<UserDto> user = userService.getUser(2);
        assertCodeSuccessful(user);
    }

    @Test
    void test2() {
        ResponseEntity<UsersDto> users = userService.getUsers(2);
    }


    @Test
    void test3() {
        ResponseEntity<NewUserDto> createUser = userService.postUser(NewUserDto.builder()
                                                                                .job("kal")
                                                                                .name("John")
                                                                                .build());

    }
}
