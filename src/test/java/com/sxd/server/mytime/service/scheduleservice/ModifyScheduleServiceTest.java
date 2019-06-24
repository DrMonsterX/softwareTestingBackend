package com.sxd.server.mytime.service.scheduleservice;

import com.sxd.server.mytime.entity.Schedule;
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
public class ModifyScheduleServiceTest {
    @Autowired
    private ModifyScheduleService modifyScheduleService;

    @Test
    public void modifyScheduleTest0() {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(5);
        schedule.setUserId(10);
        schedule.setPosition(1);
        schedule.setScheduleName("Test2");
        schedule.setStartTime("123");
        schedule.setFinishTime("321");
        schedule.setRemark("111");
        schedule.setIsRemind(1);
        assertThat(modifyScheduleService.modifySchedule(schedule),is(1));
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void modifyScheduleTest1() {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(5);
        schedule.setUserId(10);
        schedule.setPosition(1);
        schedule.setStartTime("123");
        schedule.setFinishTime("321");
        schedule.setRemark("111");
        schedule.setIsRemind(1);
        assertThat(modifyScheduleService.modifySchedule(schedule),is(1));
    }
}