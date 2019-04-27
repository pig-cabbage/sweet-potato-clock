package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.AchieveList;

import java.util.List;

public interface AchieveListService {
    /**
     * 通过userId获取achieveId信息
     *
     * @return
     */
    List<String> getAchieveListInformationByUserId(String userId);
}
