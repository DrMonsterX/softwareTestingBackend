package com.sxd.server.mytime.Service.TaskService;

import com.sxd.server.mytime.Dao.TaskMapper;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskService {
    private final TaskMapper taskMapper;

    public DeleteTaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public int deleteTask(Integer taskId){
        return taskMapper.deleteByPrimaryKey(taskId);
    }
}
