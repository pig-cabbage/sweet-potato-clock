package com.sweetpotatoclock.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Component
public class GoalComplete implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goal_complete.user_id
     *
     * @mbg.generated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goal_complete.group_id
     *
     * @mbg.generated
     */
    private Integer groupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goal_complete.completion
     *
     * @mbg.generated
     */
    private BigDecimal completion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goal_complete.is_clocked
     *
     * @mbg.generated
     */
    private Integer isClocked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table goal_complete
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goal_complete.user_id
     *
     * @return the value of goal_complete.user_id
     * @mbg.generated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goal_complete.user_id
     *
     * @param userId the value for goal_complete.user_id
     * @mbg.generated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goal_complete.group_id
     *
     * @return the value of goal_complete.group_id
     * @mbg.generated
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goal_complete.group_id
     *
     * @param groupId the value for goal_complete.group_id
     * @mbg.generated
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goal_complete.completion
     *
     * @return the value of goal_complete.completion
     * @mbg.generated
     */
    public BigDecimal getCompletion() {
        return completion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goal_complete.completion
     *
     * @param completion the value for goal_complete.completion
     * @mbg.generated
     */
    public void setCompletion(int completion) {
        this.completion = completion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goal_complete.is_clocked
     *
     * @return the value of goal_complete.is_clocked
     * @mbg.generated
     */
    public Integer getIsClocked() {
        return isClocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goal_complete.is_clocked
     *
     * @param isClocked the value for goal_complete.is_clocked
     * @mbg.generated
     */
    public void setIsClocked(Integer isClocked) {
        this.isClocked = isClocked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goal_complete
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", groupId=").append(groupId);
        sb.append(", completion=").append(completion);
        sb.append(", isClocked=").append(isClocked);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}