package com.sweetpotatoclock.dao;

import com.sweetpotatoclock.entity.GoalDayComplete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface GoalDayCompleteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_day_complete
     *
     * @mbg.generated
     */
    int insert(GoalDayComplete record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_day_complete
     *
     * @mbg.generated
     */
    List<GoalDayComplete> selectAll();

    List<GoalDayComplete> selectByUserId(String userId);
}