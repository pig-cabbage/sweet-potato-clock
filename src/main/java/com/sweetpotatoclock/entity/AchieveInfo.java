package com.sweetpotatoclock.entity;

import java.io.Serializable;

public class AchieveInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achieve_info.achieve_id
     *
     * @mbg.generated
     */
    private Integer achieveId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column achieve_info.achieve_name
     *
     * @mbg.generated
     */
    private String achieveName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table achieve_info
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column achieve_info.achieve_id
     *
     * @return the value of achieve_info.achieve_id
     *
     * @mbg.generated
     */
    public Integer getAchieveId() {
        return achieveId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column achieve_info.achieve_id
     *
     * @param achieveId the value for achieve_info.achieve_id
     *
     * @mbg.generated
     */
    public void setAchieveId(Integer achieveId) {
        this.achieveId = achieveId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column achieve_info.achieve_name
     *
     * @return the value of achieve_info.achieve_name
     *
     * @mbg.generated
     */
    public String getAchieveName() {
        return achieveName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column achieve_info.achieve_name
     *
     * @param achieveName the value for achieve_info.achieve_name
     *
     * @mbg.generated
     */
    public void setAchieveName(String achieveName) {
        this.achieveName = achieveName == null ? null : achieveName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table achieve_info
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", achieveId=").append(achieveId);
        sb.append(", achieveName=").append(achieveName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}