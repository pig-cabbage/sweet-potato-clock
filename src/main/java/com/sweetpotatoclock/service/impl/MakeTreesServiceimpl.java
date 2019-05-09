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
    public MakeTrees getMakeTreesByUserId(String userId){
        return makeTreesMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void modify(String userId,int number) {
        MakeTrees em=makeTreesMapper.selectByPrimaryKey(userId);
        int new_number=em.getTreeNumber()+number;
        double new_area=new_number*2;
        em.setArea(new_area);
        em.setTreeNumber(new_number);
        makeTreesMapper.updateByPrimaryKey(em);
    }
}
