package com.sxd.server.mytime.controller.usercontroller;

import com.sxd.server.mytime.entity.User;
import com.sxd.server.mytime.service.userservice.GetUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GetUserControllerTest {

    @Test
    public void getUserTest() {
        GetUserService getUserService=mock(GetUserService.class);
        User user=new User();
        when(getUserService.getUser(anyInt())).thenReturn(user);
        GetUserController getUserController=new GetUserController(getUserService);
        assertThat(getUserController.getUser(anyInt()),is(user));
    }
}