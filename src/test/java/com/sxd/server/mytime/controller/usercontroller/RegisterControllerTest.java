package com.sxd.server.mytime.controller.usercontroller;

import com.sxd.server.mytime.entity.User;
import com.sxd.server.mytime.service.userservice.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegisterControllerTest {

    @Test
    public void registerTest0() {
        RegisterService registerService = mock(RegisterService.class);
        when(registerService.register(any(User.class))).thenReturn(1);
        RegisterController registerController = new RegisterController(registerService);
        assertThat(registerController.register("Test4",1,"123"), greaterThan(0));
    }

    @Test
    public void registerTest1() {
        RegisterService registerService = mock(RegisterService.class);
        when(registerService.register(any(User.class))).thenReturn(1);
        RegisterController registerController = new RegisterController(registerService);
        assertThat(registerController.register(null,1,"123"), is(-1));
    }

    @Test
    public void registerTest2() {
        RegisterService registerService = mock(RegisterService.class);
        when(registerService.register(any(User.class))).thenReturn(1);
        RegisterController registerController = new RegisterController(registerService);
        assertThat(registerController.register("Test4",null,"123"), is(-1));
    }

    @Test
    public void registerTest3() {
        RegisterService registerService = mock(RegisterService.class);
        when(registerService.register(any(User.class))).thenReturn(1);
        RegisterController registerController = new RegisterController(registerService);
        assertThat(registerController.register("Test4",1,null), is(-1));
    }
}