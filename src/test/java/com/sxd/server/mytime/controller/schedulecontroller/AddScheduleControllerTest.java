package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.AddScheduleService;
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
public class AddScheduleControllerTest {

    @Test
    public void addScheduleTest0() {
        AddScheduleService addScheduleService = mock(AddScheduleService.class);
        when(addScheduleService.addSchedule(any(Schedule.class))).thenReturn(1);
        AddScheduleController addScheduleController = new AddScheduleController(addScheduleService);
        assertThat(addScheduleController.addSchedule(10,1,"Test2","123",
                "321","111",1),greaterThan(0));
    }

    @Test
    public void addScheduleTest1() {
        AddScheduleService addScheduleService = mock(AddScheduleService.class);
        when(addScheduleService.addSchedule(any(Schedule.class))).thenReturn(1);
        AddScheduleController addScheduleController = new AddScheduleController(addScheduleService);
        assertThat(addScheduleController.addSchedule(null,1,"Test2","123",
                "321","111",1),is(-1));
    }


    @Test
    public void addScheduleTest2() {
        AddScheduleService addScheduleService = mock(AddScheduleService.class);
        when(addScheduleService.addSchedule(any(Schedule.class))).thenReturn(1);
        AddScheduleController addScheduleController = new AddScheduleController(addScheduleService);
        assertThat(addScheduleController.addSchedule(10,null,"Test2","123",
                "321","111",1),is(-1));
    }

    @Test
    public void addScheduleTest3() {
        AddScheduleService addScheduleService = mock(AddScheduleService.class);
        when(addScheduleService.addSchedule(any(Schedule.class))).thenReturn(1);
        AddScheduleController addScheduleController = new AddScheduleController(addScheduleService);
        assertThat(addScheduleController.addSchedule(10,1,null,"123",
                "321","111",1),is(-1));
    }

    @Test
    public void addScheduleTest4() {
        AddScheduleService addScheduleService = mock(AddScheduleService.class);
        when(addScheduleService.addSchedule(any(Schedule.class))).thenReturn(1);
        AddScheduleController addScheduleController = new AddScheduleController(addScheduleService);
        assertThat(addScheduleController.addSchedule(10,1,"Test2",null,
                "321","111",1),is(-1));
    }

    @Test
    public void addScheduleTest5() {
        AddScheduleService addScheduleService = mock(AddScheduleService.class);
        when(addScheduleService.addSchedule(any(Schedule.class))).thenReturn(1);
        AddScheduleController addScheduleController = new AddScheduleController(addScheduleService);
        assertThat(addScheduleController.addSchedule(10,1,"Test2","123",
                null,"111",1),is(-1));
    }

    @Test
    public void addScheduleTest6() {
        AddScheduleService addScheduleService = mock(AddScheduleService.class);
        when(addScheduleService.addSchedule(any(Schedule.class))).thenReturn(1);
        AddScheduleController addScheduleController = new AddScheduleController(addScheduleService);
        assertThat(addScheduleController.addSchedule(10,1,"Test2","123",
                "321","111",null),is(-1));
    }
}