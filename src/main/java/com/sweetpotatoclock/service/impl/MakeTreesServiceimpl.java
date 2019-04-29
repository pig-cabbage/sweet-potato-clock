package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.MakeTreesMapper;
import com.sweetpotatoclock.entity.MakeTrees;
import com.sweetpotatoclock.service.MakeTreesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MakeTreesServiceimpl implements MakeTreesService {
    @Autowired
    private MakeTreesMapper makeTreesMapper;

    @Override
    public MakeTrees getMakeTreesByUserId(String userId) {
        return makeTreesMapper.selectByPrimaryKey(userId);
    }
}
