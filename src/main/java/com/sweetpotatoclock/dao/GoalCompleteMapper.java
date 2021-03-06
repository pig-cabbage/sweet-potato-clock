package com.sweetpotatoclock.dao;

import com.sweetpotatoclock.entity.GoalComplete;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoalCompleteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_complete
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(@Param("userId") String userId, @Param("groupId") Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_complete
     *
     * @mbg.generated
     */
    int insert(GoalComplete record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_complete
     *
     * @mbg.generated
     */
    GoalComplete selectByPrimaryKey(@Param("userId") String userId, @Param("groupId") Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_complete
     *
     * @mbg.generated
     */
    List<GoalComplete> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_complete
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GoalComplete record);


}