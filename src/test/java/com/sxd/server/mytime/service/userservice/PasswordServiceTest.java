package com.sxd.server.mytime.service.userservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PasswordServiceTest {
    @Autowired
    private PasswordService passwordService;

    @Test
    public void changePasswordTest0() {
        assertThat(passwordService.changePassword(10,"123"),is(1));
    }

    @Test
    public void changePasswordTest1() {
        assertThat(passwordService.changePassword(100,"123"),is(-2));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void changePasswordTest2() {
        passwordService.changePassword(10,null);
    }

    @Test
    public void changePasswordTest3() {
        assertThat(passwordService.changePassword(100,null),is(-2));
    }

    @Test
    public void changePasswordTest4() {
        assertThat(passwordService.changePassword(-1,"123"),is(-2));
    }

    @Test
    public void changePasswordTest5() {
        assertThat(passwordService.changePassword(null,"123"),is(-2));
    }
}