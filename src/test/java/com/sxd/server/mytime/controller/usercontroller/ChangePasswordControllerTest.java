package com.sxd.server.mytime.controller.usercontroller;

import com.sxd.server.mytime.service.userservice.PasswordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ChangePasswordControllerTest {

    @Test
    public void changePasswordTest() {
        PasswordService passwordService = mock(PasswordService.class);
        when(passwordService.changePassword(anyInt(),anyString())).thenReturn(1);
        ChangePasswordController changePasswordController = new ChangePasswordController(passwordService);
        assertThat(changePasswordController.changePassword(10,"123"),is(1));
    }
}