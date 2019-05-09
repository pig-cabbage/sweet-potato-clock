package com.sweetpotatoclock.service;


import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.entity.Group;

import java.util.List;

public interface GoalCompleteService {

    List<GoalComplete> queryGoalByUserId(String userId);

    List<GoalComplete> queryGoalByGroupId(Integer groupId);

    Boolean addGoalComplete(GoalComplete goalComplete);

    Boolean addGoalCompleteInCreate(Integer groupId, String userId);

    GoalComplete updateGoalComplete(Integer groupId,String userId);

    Boolean deleteGroup(Integer groupId);

    Boolean deleteGoalComplete(Integer groupId,String userId);
}
