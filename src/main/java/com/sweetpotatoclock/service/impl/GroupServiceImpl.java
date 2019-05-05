package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GoalCompleteMapper;
import com.sweetpotatoclock.dao.GroupMapper;
import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Group getGroupByGroupId(Integer groupId) {
        return groupMapper.selectByPrimaryKey(groupId);
    }

    @Override
    public List<Group> getGroupByCondition(String tag, Integer minutes, Integer days) {
        List<Group> allGroupList = groupMapper.selectAll();
        List<Group> groups = new ArrayList<>();
        for(int i = 0;i<allGroupList.size();i++){
            Group item = allGroupList.get(i);
            //同时满足三个要求
            if(item.getTag().equals(tag)&&item.getMinutes().equals(minutes)&&item.getDays().equals(days)){
                groups.add(item);
            }
        }
        return groups;
    }

    @Override
    public Boolean addGroup(Group group) {
        //创建与group表有关的相关信息并向group表中添加数据
        group.setGroupName("新小组");
        java.util.Date date = new Date();
        java.sql.Date data1 = new java.sql.Date(date.getTime());
        group.setCreateDate(data1);
        switch (group.getDays()){
            case 3 : {
                group.setJoinScore(0);
                group.setObtainScore(30);
                break;
            }

            case 7 : {
                group.setJoinScore(30);
                group.setObtainScore(100);
                break;
            }

            case 30: {
                group.setJoinScore(50);
                group.setObtainScore(200);
                break;
            }

            default:{
                group.setJoinScore(0);
                group.setObtainScore(0);
                break;
            }
        }
        group.setMemberNumber(1);
        try {
            if(groupMapper.insert(group)==1){
               return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
