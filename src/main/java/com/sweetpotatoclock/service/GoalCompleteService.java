package com.sweetpotatoclock.service;


import com.sweetpotatoclock.entity.GoalComplete;

import java.util.List;

public interface GoalCompleteService {

    List<GoalComplete> queryGoalByUserId(String userId);
}
