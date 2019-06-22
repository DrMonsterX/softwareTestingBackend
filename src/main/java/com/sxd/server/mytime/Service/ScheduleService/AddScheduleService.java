package com.sxd.server.mytime.Service.ScheduleService;

import com.sxd.server.mytime.Dao.ScheduleMapper;
import com.sxd.server.mytime.Entity.Schedule;
import org.springframework.stereotype.Service;

@Service
public class AddScheduleService {
    private final ScheduleMapper scheduleMapper;

    public AddScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public int addSchedule(Schedule schedule){
        return scheduleMapper.insert(schedule);
    }
}
