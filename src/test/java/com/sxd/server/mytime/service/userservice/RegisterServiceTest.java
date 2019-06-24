package com.sxd.server.mytime.service.userservice;

import com.sxd.server.mytime.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RegisterServiceTest {
    @Autowired
    private RegisterService registerService;

    @Test
    public void registerTest0() {
        User user = new User();
        user.setName("Test1");
        user.setIconId(1);
        user.setPassword("123");
        assertThat(registerService.register(user),greaterThan(0));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void registerTest1() {
        User user = new User();
        user.setName("Test1");
        user.setIconId(1);
        registerService.register(user);
    }
}