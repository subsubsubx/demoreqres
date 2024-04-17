package com.example.demo;

import feign.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseTest {

    @Autowired
    protected UserService userService;

}
