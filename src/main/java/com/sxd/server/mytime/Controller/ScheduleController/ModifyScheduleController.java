package com.sxd.server.mytime.Controller.ScheduleController;

import com.sxd.server.mytime.Entity.Schedule;
import com.sxd.server.mytime.Service.ScheduleService.GetScheduleService;
import com.sxd.server.mytime.Service.ScheduleService.ModifyScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyScheduleController{
    private final ModifyScheduleService modifyScheduleService;
    private final GetScheduleService getScheduleService;

    public ModifyScheduleController(ModifyScheduleService modifyScheduleService, GetScheduleService getScheduleService) {
        this.modifyScheduleService = modifyScheduleService;
        this.getScheduleService = getScheduleService;
    }

    //根据scheduleId获取schedule后修改其信息，返回结果状态码。
    @RequestMapping(value = "modifySchedule",method = RequestMethod.GET)
    public int modifySchedule(Integer scheduleId,String scheduleName,String startTime,String stopTime,String remark,Integer remind){
        Schedule schedule=getScheduleService.getScheduleById(scheduleId);
        if(schedule==null){
            return -2;
        }
        schedule.setScheduleName(scheduleName);
        schedule.setStartTime(startTime);
        schedule.setFinishTime(stopTime);
        schedule.setRemark(remark);
        schedule.setIsRemind(remind);
        return modifyScheduleService.modifySchedule(schedule);
    }
}
