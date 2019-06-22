package com.sxd.server.mytime.Controller.TaskController;

import com.sxd.server.mytime.Service.TaskService.DeleteTaskService;
import com.sxd.server.mytime.Service.TaskService.NodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeleteTaskController {
    private final DeleteTaskService deleteTaskService;
    private final NodeService nodeService;

    public DeleteTaskController(DeleteTaskService deleteTaskService, NodeService nodeService) {
        this.deleteTaskService = deleteTaskService;
        this.nodeService = nodeService;
    }

    //根据taskId删除该task以及其所属的所有node
    @RequestMapping(value = "deleteTask",method = RequestMethod.GET)
    public int deleteTask(Integer taskId){
        int result=nodeService.deleteAllNode(taskId);
        result+=deleteTaskService.deleteTask(taskId);
        return result;
    }
}
