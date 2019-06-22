package com.sxd.server.mytime.controller.taskcontroller;

import com.sxd.server.mytime.entity.Task;
import com.sxd.server.mytime.service.taskservice.GetTaskService;
import com.sxd.server.mytime.service.taskservice.ModifyTaskService;
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
