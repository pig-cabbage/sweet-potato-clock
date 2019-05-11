package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.RankBetweenGroup;

import java.util.List;

public interface RankBetweenGroupService {
    /**
     * 获取RankBetweenGroup列表信息
     *
     * @return
     */


    RankBetweenGroup getRankBetweenGroupById(Integer groupId);

    /**
     * 依据当日人均打卡时长对获取RankBetweenGroup列表进行降序排序
     *
     * @return
     */
    List<RankBetweenGroup> rankByDayAverageMinutes();

    /**
     * 依据一周人均打卡时长对获取RankBetweenGroup列表进行降序排序
     *
     * @return
     */
    List<RankBetweenGroup> rankByWeekAverageMinutes();



    Boolean updateRankBetweenGroup(RankBetweenGroup rankBetweenGroup);

    Boolean addRankBetweenGroupInCreate(Integer groupId);

    Boolean deleteRankBetweenGroup(Integer groupId);
    /**
     * 返回对应的名称列表
     *
     * @return
     */
    List<String>returnNameListDay();

    List<String>returnNameListWeek();
}
