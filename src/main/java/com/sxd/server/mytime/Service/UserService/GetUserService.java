package com.sxd.server.mytime.Service.UserService;

import com.sxd.server.mytime.Dao.UserMapper;
import com.sxd.server.mytime.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class GetUserService {
    private final UserMapper userMapper;

    public GetUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    //通过userId主键查询user信息
    public User getUser(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }
}
