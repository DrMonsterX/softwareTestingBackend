package com.sxd.server.mytime.Service.UserService;

import com.sxd.server.mytime.Dao.UserMapper;
import com.sxd.server.mytime.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private final UserMapper userMapper;

    public PasswordService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //修改用户密码，返回修改结果。0失败，1成功，2用户不存在
    public int changePassword(Integer userId,String password){
        User user= userMapper.selectByPrimaryKey(userId);
        if(user==null){
            return 2;//用户不存在
        }
        user.setPassword(password);
        return userMapper.updateByPrimaryKey(user);
    }
}
