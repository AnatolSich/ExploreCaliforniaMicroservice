package com.example.explore.exploreCalifornia.web;

import com.example.explore.exploreCalifornia.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @MockBean
    private UserService service;
    @Test
    public void login() {

    }

    @Test
    public void getAllUsers() {
    }
}