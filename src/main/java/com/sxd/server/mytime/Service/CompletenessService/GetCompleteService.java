package com.sxd.server.mytime.Service.CompletenessService;

import com.sxd.server.mytime.Dao.CompletenessMapper;
import com.sxd.server.mytime.Dao.UserMapper;
import com.sxd.server.mytime.Entity.Completeness;
import com.sxd.server.mytime.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class GetCompleteService {
    private final CompletenessMapper completenessMapper;
    private final UserMapper userMapper;

    public GetCompleteService(CompletenessMapper completenessMapper, UserMapper userMapper) {
        this.completenessMapper = completenessMapper;
        this.userMapper = userMapper;
    }

    //根据用户id获取完成度id号，进而获取完成度数据
    public Completeness getCompleteness(Integer userId){
        User user=userMapper.selectByPrimaryKey(userId);
        if(user==null){
            return null;
        }
        int completenessId=user.getCompletenessId();
        return completenessMapper.selectByPrimaryKey(completenessId);
    }
}
