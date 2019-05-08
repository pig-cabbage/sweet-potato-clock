package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.UserInformationMapper;
import com.sweetpotatoclock.entity.UserInformation;
import com.sweetpotatoclock.service.BuyTreesService;
import org.springframework.beans.factory.annotation.Autowired;

public class BuyTreesServiceimpl implements BuyTreesService {
    @Autowired
    private UserInformationMapper userInformationMapper;

    /**
     * 暂时先定义一颗树需要10积分
     *
     *
     */
    @Override
    public int buyTrees(String userId, int number){
        UserInformation userInformation=userInformationMapper.selectByPrimaryKey(userId);
        if(userInformation.getScore()<number*10)
            return 0;
        else{
            int newScore=userInformation.getScore()-number*10;
            userInformation.setScore(newScore);
            userInformationMapper.updateByPrimaryKey(userInformation);
            return 1;
        }
    }
}
