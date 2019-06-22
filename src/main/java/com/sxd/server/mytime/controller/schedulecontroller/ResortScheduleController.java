package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.ModifyScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResortScheduleController {
    private final GetScheduleController getScheduleController;
    private final ModifyScheduleService modifyScheduleService;
    private static final int SCHEDULE_NOT_FOUND = -2;

    public ResortScheduleController(GetScheduleController getScheduleController, ModifyScheduleService modifyScheduleService) {
        this.getScheduleController = getScheduleController;
        this.modifyScheduleService = modifyScheduleService;
    }

    //修改日程位置信息
    @RequestMapping(value = "resortSchedule", method = RequestMethod.GET)
    public int resortSchedule(Integer scheduleId, Integer position) {
        Schedule schedule = getScheduleController.getScheduleById(scheduleId);
        if (schedule == null) {
            return SCHEDULE_NOT_FOUND;
        }
        schedule.setPosition(position);
        return modifyScheduleService.modifySchedule(schedule);
    }
}
