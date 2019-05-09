package com.sweetpotatoclock.service;


import com.sweetpotatoclock.entity.GoalComplete;

import java.util.List;

public interface GoalCompleteService {

    List<GoalComplete> queryGoalByUserId(String userId);

    List<GoalComplete> queryGoalByGroupId(Integer groupId);

    Boolean addGoalComplete(GoalComplete goalComplete);

    Boolean addGoalCompleteInCreate(Integer groupId, String userId);

    Boolean updateGoalComplete(Integer groupId,String userId);

    Boolean deleteGroup(Integer groupId);

    Boolean deleteGoalComplete(Integer groupId,String userId);
}
