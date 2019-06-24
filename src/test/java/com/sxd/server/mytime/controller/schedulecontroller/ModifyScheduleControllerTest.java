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
public class ModifyScheduleControllerTest {

    @Test
    public void modifyScheduleTest0() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ModifyScheduleController modifyScheduleController = new ModifyScheduleController(modifyScheduleService,getScheduleService);
        assertThat(modifyScheduleController.modifySchedule(100,"test",
                "123","321","",1),is(-2));
    }

    @Test
    public void modifyScheduleTest1() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ModifyScheduleController modifyScheduleController = new ModifyScheduleController(modifyScheduleService,getScheduleService);
        assertThat(modifyScheduleController.modifySchedule(5,"test",
                "123","321","",1),is(1));
    }

    @Test
    public void modifyScheduleTest2() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ModifyScheduleController modifyScheduleController = new ModifyScheduleController(modifyScheduleService,getScheduleService);
        assertThat(modifyScheduleController.modifySchedule(5,null,
                "123","321","",1),is(-1));
    }

    @Test
    public void modifyScheduleTest3() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ModifyScheduleController modifyScheduleController = new ModifyScheduleController(modifyScheduleService,getScheduleService);
        assertThat(modifyScheduleController.modifySchedule(5,"test",
                null,"321","",1),is(-1));
    }

    @Test
    public void modifyScheduleTest4() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ModifyScheduleController modifyScheduleController = new ModifyScheduleController(modifyScheduleService,getScheduleService);
        assertThat(modifyScheduleController.modifySchedule(5,"test",
                "123",null,"",1),is(-1));
    }

    @Test
    public void modifyScheduleTest5() {
        ModifyScheduleService modifyScheduleService = mock(ModifyScheduleService.class);
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        when(getScheduleService.getScheduleById(100)).thenReturn(null);
        when(modifyScheduleService.modifySchedule(any(Schedule.class))).thenReturn(1);
        ModifyScheduleController modifyScheduleController = new ModifyScheduleController(modifyScheduleService,getScheduleService);
        assertThat(modifyScheduleController.modifySchedule(100,"test",
                "123","321","",null),is(-1));
    }
}