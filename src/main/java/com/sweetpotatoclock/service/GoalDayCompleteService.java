package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.GoalDayComplete;

import java.util.List;

public interface GoalDayCompleteService {
    /**
     * 通过userId获取GoalDayComplete列表信息
     *
     * @return
     */
    List<GoalDayComplete> getGoalDayCompleteByUserId(String userId);

    Boolean addGoalDayComplete(GoalDayComplete goalDayComplete);
}
