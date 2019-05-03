package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.AchieveInfoMapper;
import com.sweetpotatoclock.dao.AchieveListMapper;
import com.sweetpotatoclock.entity.AchieveList;
import com.sweetpotatoclock.service.AchieveListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AchieveListServiceimpl implements AchieveListService {
    @Autowired
    private AchieveListMapper achieveListMapper;
    @Autowired
    private AchieveInfoMapper achieveInfoMapper;

    @Override
    public List<String> getAchieveListInformationByUserId(String userId) {
        List<AchieveList> list1 = achieveListMapper.selectAchieveListByUserId(userId);
        List<String> list2 =  Arrays.asList(new String[list1.size()]);
        for (int i = 0; i <list1.size(); ++i) {
            Integer a=list1.get(i).getAchieveId();
            list2.set(i,achieveInfoMapper.selectByPrimaryKey(a).getAchieveName());
    }
        return list2;
    }

}
