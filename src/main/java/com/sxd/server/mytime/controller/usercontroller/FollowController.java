package com.sxd.server.mytime.controller.usercontroller;

import com.sxd.server.mytime.entity.Follow;
import com.sxd.server.mytime.entity.User;
import com.sxd.server.mytime.service.userservice.FollowService;
import com.sxd.server.mytime.service.userservice.GetUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FollowController {
    private final FollowService followService;
    private final GetUserService getUserService;

    public FollowController(FollowService followService, GetUserService getUserService) {
        this.followService = followService;
        this.getUserService = getUserService;
    }

    //获取当前id用户的所有关注人
    @RequestMapping(value = "getFollow",method = RequestMethod.GET)
    public List<User> getFollow(Integer userId){
        List<Follow> follow=followService.getFollow(userId);
        List<User> userList=new ArrayList<>();
        if(follow==null){
            return null;
        }else{
            for (Follow nowFollow:follow) {
                User user=getUserService.getUser(nowFollow.getFollowedId());
                userList.add(user);
            }
        }
        return userList;
    }

    //通过自身id和目标id来关注用户
    @RequestMapping(value = "followUser",method = RequestMethod.GET)
    public int followUser(Integer myId,Integer targetId){
        Follow follow=new Follow();
        if(myId.equals(targetId)){
            return -2;
        }
        //校验myId用户是否不存在
        User myUser=getUserService.getUser(myId);
        if(myUser==null){
            return -3;
        }else{
            follow.setFollowingId(myId);
        }

        //校验targetId用户是否不存在
        User targetUser=getUserService.getUser(targetId);
        if(targetUser==null){
            return -4;
        }else{
            follow.setFollowedId(targetId);
        }

        //添加关注
        return followService.followUser(follow);
    }

    //使当前用户取消关注目标用户
    @RequestMapping(value = "deleteFollow",method = RequestMethod.GET)
    public int deleteFollow(Integer myId,Integer targetId){
        //检验当前用户id与目标用户id是否相同
        if(myId.equals(targetId)){
            return -2;
        }

        //校验myId用户是否不存在
        User myUser=getUserService.getUser(myId);
        if(myUser==null){
            return -3;
        }

        //校验targetId用户是否不存在
        User targetUser=getUserService.getUser(targetId);
        if(targetUser==null){
            return -4;
        }
        return followService.deleteFollow(myId,targetId);
    }
}
