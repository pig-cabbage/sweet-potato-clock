package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GoalDayCompleteMapper;
import com.sweetpotatoclock.entity.GoalDayComplete;
import com.sweetpotatoclock.service.GoalDayCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalDayCompleteServiceimpl implements GoalDayCompleteService {
    @Autowired
    private GoalDayCompleteMapper goalDayCompleteMapper;

    @Override
    public List<GoalDayComplete> getGoalDayCompleteByUserId(String userId) {
        return goalDayCompleteMapper.selectByUserId(userId);
    }
}
