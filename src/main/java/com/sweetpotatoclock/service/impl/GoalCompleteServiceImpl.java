package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GoalCompleteMapper;
import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.GoalDayComplete;
import com.sweetpotatoclock.service.GoalCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class GoalCompleteServiceImpl implements GoalCompleteService {

    @Autowired
    GoalCompleteMapper goalCompleteMapper;

    /**
     * 根据userId查找出对应userId的打卡目标
     * @param userId
     * @return userGoal
     */
    @Override
    public List<GoalComplete> queryGoalByUserId(String userId) {
        List<GoalComplete> allGoal= goalCompleteMapper.selectAll();
        List<GoalComplete> userGoal= new ArrayList<GoalComplete>();
        //从allGoal中找出指定userId的goal信息，包括groupId，complete等
        for(int i=0;i<allGoal.size();i++){
            if(allGoal.get(i).getUserId().equals(userId)){
                userGoal.add(allGoal.get(i));
            }
        }
        return userGoal;
    }

    @Override
    public List<GoalComplete> queryGoalByGroupId(Integer groupId) {
        List<GoalComplete> allGoal= goalCompleteMapper.selectAll();
        List<GoalComplete> groupGoal = new ArrayList<>();
        for(int i=0;i<allGoal.size();i++){
            if(allGoal.get(i).getGroupId().equals(groupId)){
                groupGoal.add(allGoal.get(i));
            }
        }
        return groupGoal;
    }

    @Override
    public Boolean addGoalComplete(GoalComplete goalComplete) {
        try {
            if(goalCompleteMapper.insert(goalComplete)==1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean addGoalCompleteInCreate(Integer groupId, String userId) {
        GoalComplete goalComplete=new GoalComplete();
        goalComplete.setGroupId(groupId);
        goalComplete.setUserId(userId);
        goalComplete.setCompletion(0);
        goalComplete.setIsClocked(0);
        if(goalCompleteMapper.insert(goalComplete)==1){
            return true;
        }
        return false;
    }
}
