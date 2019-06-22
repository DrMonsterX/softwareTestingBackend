package com.sxd.server.mytime.Controller.TaskController;

import com.sxd.server.mytime.Entity.Task;
import com.sxd.server.mytime.Service.TaskService.GetTaskService;
import com.sxd.server.mytime.Service.TaskService.ModifyTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinishTaskController {
    private final ModifyTaskService modifyTaskService;
    private final GetTaskService getTaskService;

    public FinishTaskController(ModifyTaskService modifyTaskService, GetTaskService getTaskService) {
        this.modifyTaskService = modifyTaskService;
        this.getTaskService = getTaskService;
    }

    //修改任务完成信息
    @RequestMapping(value = "finishTask",method = RequestMethod.GET)
    public int finishTask(Integer taskId,Integer finishNum){
        Task task=getTaskService.getTaskById(taskId);
        if(task==null){
            return -2;
        }
        task.setIsComplete(finishNum);
        return modifyTaskService.modifyTask(task);
    }
}
