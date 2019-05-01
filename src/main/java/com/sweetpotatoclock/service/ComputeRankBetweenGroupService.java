package com.sweetpotatoclock.service;

import com.sweetpotatoclock.entity.RankBetweenGroup;

public interface ComputeRankBetweenGroupService {

    RankBetweenGroup computeRankBetweenGroupMinutes(Integer groupId,Integer minutes);
}
