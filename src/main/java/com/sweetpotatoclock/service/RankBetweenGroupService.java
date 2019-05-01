package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.RankBetweenGroup;

import java.util.List;

public interface RankBetweenGroupService {
    /**
     * 获取RankBetweenGroup列表信息
     *
     * @return
     */
    void getRankBetweenGroupList();

    /**
     * 依据当日人均打卡时长对获取RankBetweenGroup列表进行降序排序
     *
     * @return
     */
    void rankByDayAverageMinutes();

    /**
     * 依据一周人均打卡时长对获取RankBetweenGroup列表进行降序排序
     *
     * @return
     */
    void rankByWeekAverageMinutes();

    List<RankBetweenGroup> getList();

    Boolean updateRankBetweenGroup(RankBetweenGroup rankBetweenGroup);
}
