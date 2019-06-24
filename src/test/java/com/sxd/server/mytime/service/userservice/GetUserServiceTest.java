package com.sxd.server.mytime.service.userservice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GetUserServiceTest {
    @Autowired
    private GetUserService getUserService;

    @Test
    public void getUserTest0() {
        assertThat(getUserService.getUser(-1),nullValue());
    }

    @Test
    public void getUserTest1() {
        assertThat(getUserService.getUser(10).getUserId(),is(10));
    }

    @Test
    public void getUserTest2() {
        assertThat(getUserService.getUser(100),nullValue());
    }

    @Test
    public void getUserTest3() {
        assertThat(getUserService.getUser(null),nullValue());
    }
}