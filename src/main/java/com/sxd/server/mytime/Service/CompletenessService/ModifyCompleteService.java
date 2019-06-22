package com.sxd.server.mytime.Service.CompletenessService;

import com.sxd.server.mytime.Dao.CompletenessMapper;
import com.sxd.server.mytime.Entity.Completeness;
import org.springframework.stereotype.Service;

@Service
public class ModifyCompleteService {
    private final CompletenessMapper completenessMapper;

    public ModifyCompleteService(CompletenessMapper completenessMapper) {
        this.completenessMapper = completenessMapper;
    }

    public int updateCompleteness(Completeness completeness){
        return completenessMapper.updateByPrimaryKey(completeness);
    }
}
