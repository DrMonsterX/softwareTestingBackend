package com.sxd.server.mytime.Controller.CompleteController;

import com.sxd.server.mytime.Entity.Completeness;
import com.sxd.server.mytime.Service.CompletenessService.GetCompleteService;
import com.sxd.server.mytime.Service.CompletenessService.ModifyCompleteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateCompleteController {
    private final GetCompleteService getCompleteService;
    private final ModifyCompleteService modifyCompleteService;

    public UpdateCompleteController(GetCompleteService getCompleteService, ModifyCompleteService modifyCompleteService) {
        this.getCompleteService = getCompleteService;
        this.modifyCompleteService = modifyCompleteService;
    }

    //更新本周实时完成度
    @RequestMapping(value = "updateComplete",method = RequestMethod.GET)
    public int updateComplete(Integer userId,Integer weekCompleteness){
        Completeness completeness=getCompleteService.getCompleteness(userId);
        if(completeness==null){
            return -2;
        }
        completeness.setWeekCompleteness(weekCompleteness);
        return modifyCompleteService.updateCompleteness(completeness);
    }
}
