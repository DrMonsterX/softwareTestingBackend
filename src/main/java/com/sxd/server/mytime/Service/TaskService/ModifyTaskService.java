package com.sxd.server.mytime.Service.TaskService;

import com.sxd.server.mytime.Dao.TaskMapper;
import com.sxd.server.mytime.Entity.Task;
import org.springframework.stereotype.Service;

@Service
public class ModifyTaskService {
    private final TaskMapper taskMapper;

    public ModifyTaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public int modifyTask(Task task){
        return taskMapper.updateByPrimaryKey(task);
    }
}
