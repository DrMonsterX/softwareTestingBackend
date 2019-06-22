package com.sxd.server.mytime.controller.schedulecontroller;

import com.sxd.server.mytime.entity.Schedule;
import com.sxd.server.mytime.service.scheduleservice.AddScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddScheduleController {
    private final AddScheduleService addScheduleService;

    public AddScheduleController(AddScheduleService addScheduleService) {
        this.addScheduleService = addScheduleService;
    }

    //添加日程
    @RequestMapping(value = "addSchedule",method = RequestMethod.GET)
    public int addSchedule(Integer userId,Integer position,String scheduleName, String startTime, String stopTime, String remark,Integer remind){
        Schedule schedule=new Schedule();
        schedule.setUserId(userId);
        schedule.setPosition(position);
        schedule.setScheduleName(scheduleName);
        schedule.setStartTime(startTime);
        schedule.setFinishTime(stopTime);
        schedule.setRemark(remark);
        schedule.setIsRemind(remind);
        return addScheduleService.addSchedule(schedule);
    }
}
