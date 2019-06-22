package com.sxd.server.mytime.Service.TaskService;


import com.sxd.server.mytime.Dao.TaskMapper;
import com.sxd.server.mytime.Entity.Task;
import org.springframework.stereotype.Service;

@Service
public class AddTaskService {
    private final TaskMapper taskMapper;

    public AddTaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public int addTask(Task task){
        return taskMapper.insert(task);
    }

}
