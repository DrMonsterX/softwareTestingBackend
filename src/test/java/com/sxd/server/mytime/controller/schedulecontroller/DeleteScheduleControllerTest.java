package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.service.scheduleservice.DeleteScheduleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DeleteScheduleControllerTest {

    @Test
    public void deleteSchedule() {
        DeleteScheduleService deleteScheduleService = mock(DeleteScheduleService.class);
        when(deleteScheduleService.deleteSchedule(anyInt())).thenReturn(1);
        DeleteScheduleController deleteScheduleController = new DeleteScheduleController(deleteScheduleService);
        assertThat(deleteScheduleController.deleteSchedule(5),is(1));
    }
}