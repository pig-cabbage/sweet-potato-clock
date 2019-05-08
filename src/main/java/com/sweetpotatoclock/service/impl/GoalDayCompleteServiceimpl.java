package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GoalDayCompleteMapper;
import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.GoalDayComplete;
import com.sweetpotatoclock.service.GoalDayCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoalDayCompleteServiceimpl implements GoalDayCompleteService {
    @Autowired
    private GoalDayCompleteMapper goalDayCompleteMapper;
    @Autowired
    private GoalComplete goalComplete;

    @Override
    public List<GoalDayComplete> getGoalDayCompleteByUserId(String userId) {
        return goalDayCompleteMapper.selectByUserId(userId);
    }

    @Override
    public Boolean addGoalDayComplete(GoalDayComplete goalDayComplete) {
        Date date= new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        goalDayComplete.setCompleteDate(date1);
        if(goalDayCompleteMapper.insert(goalDayComplete)==1){
            return true;
        }
        return false;
    }
}
