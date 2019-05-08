package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GoalCompleteMapper;
import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.GoalDayComplete;
import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class GoalCompleteServiceImpl implements GoalCompleteService {

    @Autowired
    GoalCompleteMapper goalCompleteMapper;
    @Autowired
    GroupService groupService;

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
        goalComplete.setCompletion((double) 0);
        goalComplete.setIsClocked(0);
        if(goalCompleteMapper.insert(goalComplete)==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateGoalComplete(Integer groupId, String userId) {
        List<GoalComplete> allGoal= goalCompleteMapper.selectAll();
        GoalComplete groupUserGoal = new GoalComplete();
        Group group=groupService.getGroupByGroupId(groupId);
        try {
            for (int i = 0; i < allGoal.size(); i++) {
                if (allGoal.get(i).getGroupId().equals(groupId) && allGoal.get(i).getUserId().equals(userId)) {
                    groupUserGoal = allGoal.get(i);
                    break;
                }
            }
            groupUserGoal.setIsClocked(1);
            //计算并添加完成度(旧的完成度*要求连续天数+1）/要求连续天数
            Double completionNew = ((groupUserGoal.getCompletion().doubleValue() * group.getDays()) + 1) / group.getDays();
            groupUserGoal.setCompletion(completionNew);
            //System.out.print(groupUserGoal.getCompletion()+"\n");
            goalCompleteMapper.updateById(groupUserGoal);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteGroup(Integer groupId) {

        if(goalCompleteMapper.deleteByGroupId(groupId)==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteGoalComplete(Integer groupId, String userId) {
        GoalComplete goalComplete = new GoalComplete();
        goalComplete.setUserId(userId);
        goalComplete.setGroupId(groupId);
        if(goalCompleteMapper.deleteByGroupIdAndUserId(goalComplete)==1){
            return true;
        }
        return false;
    }
}
