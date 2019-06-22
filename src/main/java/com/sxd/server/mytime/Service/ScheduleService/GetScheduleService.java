package com.sxd.server.mytime.Service.ScheduleService;

import com.sxd.server.mytime.Dao.ScheduleMapper;
import com.sxd.server.mytime.Entity.Schedule;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GetScheduleService {
    private final ScheduleMapper scheduleMapper;

    public GetScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    //根据scheduleId获取对应的schedule实体
    public Schedule getScheduleById(Integer scheduleId){
        return scheduleMapper.selectByPrimaryKey(scheduleId);
    }

    //获取目标用户的所有日程
    public List<Schedule> getScheduleByUser(Integer userId){
        Example example=new Example(Schedule.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("userId",userId);
        return scheduleMapper.selectByExample(example);
    }
}
