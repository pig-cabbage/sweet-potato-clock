package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.RankInGroup;

import java.util.List;

public interface RankInGroupService {
    /**
     * 根据groupId获取RankInGroup列表
     *
     * @return
     */


    /**
     * 依据每日打卡时长对获取RankInGroup列表进行降序排序
     *
     * @return
     */
    List<RankInGroup> rankByDayMinutes(Integer groupId);

    /**
     * 依据每周打卡时长对获取RankInGroup列表进行降序排序
     *
     * @return
     */

    List<RankInGroup> rankByWeekMinutes(Integer groupId);



    Boolean updateRankInGroup(RankInGroup rankInGroup);

    RankInGroup updateWeekMinutes(RankInGroup rankInGroup);

    Boolean addRankInGroupInCreate(Integer groupId, String userId);

    Boolean deleteRankInGroup(Integer groupId);

    /**
     * 返回对应的名称列表
     *
     * @return
     */
    List<String> returnNameListDay(Integer groupId);

    List<String> returnNameListWeek(Integer groupId);
}
