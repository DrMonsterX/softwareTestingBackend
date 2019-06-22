package com.sxd.server.mytime.Service.ScheduleService;

import com.sxd.server.mytime.Dao.ScheduleMapper;
import com.sxd.server.mytime.Entity.Schedule;
import org.springframework.stereotype.Service;

@Service
public class ModifyScheduleService {
    private final ScheduleMapper scheduleMapper;

    public ModifyScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public int modifySchedule(Schedule schedule){
        return scheduleMapper.updateByPrimaryKey(schedule);
    }
}
