package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.RankInGroupMapper;
import com.sweetpotatoclock.entity.RankInGroup;
import com.sweetpotatoclock.service.RankInGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RanInGroupServiceimpl implements RankInGroupService {
    @Autowired
    private RankInGroupMapper rankInGroupMapper;

    private List<RankInGroup> list = new ArrayList<>();

    @Override
    public void getRankInGroupListByGroupId(Integer groupId) {
        list = rankInGroupMapper.selectListByGroupId(groupId);

    }

    @Override
    public void rankByDayMinutes() {
        Collections.sort(list, new Comparator<RankInGroup>() {
            @Override
            public int compare(RankInGroup t1, RankInGroup t2) {
                return t2.getDayMinutes().compareTo(t1.getDayMinutes());
            }
        });

    }

    @Override
    public void rankByWeekMinutes() {
        Collections.sort(list, new Comparator<RankInGroup>() {
            @Override
            public int compare(RankInGroup t1, RankInGroup t2) {
                return t2.getWeekMinutes().compareTo(t1.getWeekMinutes());
            }
        });
    }

    public List<RankInGroup> getList() {
        return list;
    }


    @Override
    public Boolean updateRankInGroup(RankInGroup rankInGroup) {
        try {
            if(rankInGroupMapper.updateById(rankInGroup)==1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer updateWeekMinutes(RankInGroup rankInGroup) {
        return null;
    }
}
