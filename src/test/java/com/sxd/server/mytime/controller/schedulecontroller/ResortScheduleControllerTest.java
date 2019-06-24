package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.GetScheduleService;
import com.sxd.server.mytime.service.scheduleservice.ModifyScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ResortScheduleControllerTest {

    @Test
    public void resortScheduleTest0() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ResortScheduleController resortScheduleController = new ResortScheduleController(getScheduleService,modifyScheduleService);
        assertThat(resortScheduleController.resortSchedule(100,2),is(-2));
    }

    @Test
    public void resortScheduleTest1() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ResortScheduleController resortScheduleController = new ResortScheduleController(getScheduleService,modifyScheduleService);
        assertThat(resortScheduleController.resortSchedule(5,1),is(1));
    }

    @Test
    public void resortScheduleTest2() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ResortScheduleController resortScheduleController = new ResortScheduleController(getScheduleService,modifyScheduleService);
        assertThat(resortScheduleController.resortSchedule(5,null),is(-1));
    }
}