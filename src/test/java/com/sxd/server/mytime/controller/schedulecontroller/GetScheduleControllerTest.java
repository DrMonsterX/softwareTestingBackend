package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.GetScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.AssertTrue;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GetScheduleControllerTest {

    @Test
    public void getScheduleById() {
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        Schedule schedule = new Schedule();
        when(getScheduleService.getScheduleById(anyInt())).thenReturn(schedule);
        GetScheduleController getScheduleController = new GetScheduleController(getScheduleService);
        assertThat(getScheduleController.getScheduleById(5),is(schedule));
    }

    @Test
    public void getScheduleByUser() {
        GetScheduleService getScheduleService = mock(GetScheduleService.class);
        List<Schedule> list = new ArrayList<>();
        Schedule schedule = new Schedule();
        list.add(schedule);
        when(getScheduleService.getScheduleByUser(anyInt())).thenReturn(list);
        GetScheduleController getScheduleController = new GetScheduleController(getScheduleService);
        assertThat(getScheduleController.getScheduleByUser(10),is(list));
    }
}