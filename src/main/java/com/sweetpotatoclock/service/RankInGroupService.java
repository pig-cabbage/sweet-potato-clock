package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.RankInGroup;

import java.util.List;

public interface RankInGroupService {
    /**
     * 根据groupId获取RankInGroup列表
     *
     * @return
     */
    void getRankInGroupListByGroupId(Integer groupId);

    /**
     * 依据每日打卡时长对获取RankInGroup列表进行降序排序
     *
     * @return
     */
    void rankByDayMinutes();

    /**
     * 依据每周打卡时长对获取RankInGroup列表进行降序排序
     *
     * @return
     */

    void rankByWeekMinutes();

    List<RankInGroup> getList();

    Boolean updateRankInGroup(RankInGroup rankInGroup);

    Integer updateWeekMinutes(RankInGroup rankInGroup);
}
