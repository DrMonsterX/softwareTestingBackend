package com.sxd.server.mytime.Controller.TaskController;

import com.sxd.server.mytime.Entity.Task;
import com.sxd.server.mytime.Service.TaskService.GetTaskService;
import com.sxd.server.mytime.Service.TaskService.ModifyTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResortTaskController {
    private final ModifyTaskService modifyTaskService;
    private final GetTaskService getTaskService;

    public ResortTaskController(ModifyTaskService modifyTaskService, GetTaskService getTaskService) {
        this.modifyTaskService = modifyTaskService;
        this.getTaskService = getTaskService;
    }

    //对任务进行重新排序
    @RequestMapping(value = "resortTask",method = RequestMethod.GET)
    public int resortTask(Integer taskId,Integer position){
        Task task=getTaskService.getTaskById(taskId);
        if(task==null){
            return -2;
        }
        task.setPosition(position);
        return modifyTaskService.modifyTask(task);
    }
}
