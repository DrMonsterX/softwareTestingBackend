package com.sxd.server.mytime.Controller.TaskController;

import com.sxd.server.mytime.Entity.Task;
import com.sxd.server.mytime.Service.TaskService.GetTaskService;
import com.sxd.server.mytime.Service.TaskService.ModifyTaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModifyTaskController {
    private final ModifyTaskService modifyTaskService;
    private final GetTaskService getTaskService;

    public ModifyTaskController(ModifyTaskService modifyTaskService, GetTaskService getTaskService) {
        this.modifyTaskService = modifyTaskService;
        this.getTaskService = getTaskService;
    }

    //修改任务,返回结果状态码
    @RequestMapping(value = "modifyTask",method = RequestMethod.GET)
    public int modifyTask(Integer taskId,String taskName,String startTime,String stopTime,Integer remind,String remark,String tag){
        Task task=getTaskService.getTaskById(taskId);
        if(task==null){
            return -2;
        }
        task.setTaskName(taskName);
        task.setStartTime(startTime);
        task.setFinishTime(stopTime);
        task.setRemind(remind);
        task.setRemark(remark);
        task.setTag(tag);
        return modifyTaskService.modifyTask(task);
    }
}
