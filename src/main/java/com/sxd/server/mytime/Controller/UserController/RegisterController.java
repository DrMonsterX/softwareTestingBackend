package com.sxd.server.mytime.Controller.UserController;

import com.sxd.server.mytime.Entity.User;
import com.sxd.server.mytime.Service.UserService.RegisterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    //用户注册
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public int register(String name,Integer iconId,String password){
        User user=new User();
        user.setName(name);
        user.setIconId(iconId);
        user.setPassword(password);
        return registerService.register(user);
    }
}
