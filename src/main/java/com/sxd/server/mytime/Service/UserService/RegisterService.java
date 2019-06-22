package com.sxd.server.mytime.Service.UserService;

import com.sxd.server.mytime.Dao.CompletenessMapper;
import com.sxd.server.mytime.Dao.UserMapper;
import com.sxd.server.mytime.Entity.Completeness;
import com.sxd.server.mytime.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final UserMapper userMapper;
    private final CompletenessMapper completenessMapper;

    public RegisterService(UserMapper userMapper, CompletenessMapper completenessMapper) {
        this.userMapper = userMapper;
        this.completenessMapper = completenessMapper;
    }

    public int register(User user){
        Completeness completeness=new Completeness();
        completenessMapper.insert(completeness);
        Integer completenessId=completeness.getCompletenessId();
        user.setCompletenessId(completenessId);
        userMapper.insert(user);
        return user.getUserId();
    }
}
