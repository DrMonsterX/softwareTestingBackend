package com.sxd.server.mytime.service.scheduleservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GetScheduleServiceTest {
    @Autowired
    private GetScheduleService getScheduleService;

    @Test
    public void getScheduleByIdTest0() {
        assertThat(getScheduleService.getScheduleById(-1),nullValue());
    }

    @Test
    public void getScheduleByIdTest1() {
        assertThat(getScheduleService.getScheduleById(5),notNullValue());
    }

    @Test
    public void getScheduleByIdTest2() {
        assertThat(getScheduleService.getScheduleById(100),nullValue());
    }

    @Test
    public void getScheduleByUserTest0() {
        assertThat(getScheduleService.getScheduleByUser(-1),is(empty()));
    }

    @Test
    public void getScheduleByUserTest1() {
        assertThat(getScheduleService.getScheduleByUser(10).size(),greaterThan(0));
    }

    @Test
    public void getScheduleByUserTest2() {
        assertThat(getScheduleService.getScheduleByUser(100),is(empty()));
    }
}