package com.sweetpotatoclock.entity;

import java.io.Serializable;

public class GoalComplete implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goal_complete.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goal_complete.group_id
     *
     * @mbg.generated
     */
    private Integer groupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goal_complete.completion
     *
     * @mbg.generated
     */
    private Long completion;

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
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goal_complete.user_id
     *
     * @param userId the value for goal_complete.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goal_complete.group_id
     *
     * @return the value of goal_complete.group_id
     *
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
     *
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
     *
     * @mbg.generated
     */
    public Long getCompletion() {
        return completion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goal_complete.completion
     *
     * @param completion the value for goal_complete.completion
     *
     * @mbg.generated
     */
    public void setCompletion(Long completion) {
        this.completion = completion;
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}