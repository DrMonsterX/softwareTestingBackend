package com.sxd.server.mytime.Controller.ScheduleController;

import com.sxd.server.mytime.Entity.Schedule;
import com.sxd.server.mytime.Service.ScheduleService.ModifyScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResortScheduleController {
    private final GetScheduleController getScheduleController;
    private final ModifyScheduleService modifyScheduleService;

    public ResortScheduleController(GetScheduleController getScheduleController, ModifyScheduleService modifyScheduleService) {
        this.getScheduleController = getScheduleController;
        this.modifyScheduleService = modifyScheduleService;
    }

    //修改日程位置信息
    @RequestMapping(value = "resortSchedule",method = RequestMethod.GET)
    public int resortSchedule(Integer scheduleId,Integer position){
        Schedule schedule=getScheduleController.getScheduleById(scheduleId);
        if(schedule==null){
            return -2;
        }
        schedule.setPosition(position);
        return modifyScheduleService.modifySchedule(schedule);
    }
}
