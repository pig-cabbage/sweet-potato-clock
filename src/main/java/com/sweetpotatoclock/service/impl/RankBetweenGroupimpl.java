package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.RankBetweenGroupMapper;
import com.sweetpotatoclock.dao.RankInGroupMapper;
import com.sweetpotatoclock.entity.RankBetweenGroup;
import com.sweetpotatoclock.entity.RankInGroup;
import com.sweetpotatoclock.service.RankBetweenGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class RankBetweenGroupimpl implements RankBetweenGroupService {
    @Autowired
    private RankBetweenGroupMapper rankBetweenGroupMapper;

    private List<RankBetweenGroup> list = new ArrayList<>();

    @Override
    public void getRankBetweenGroupList() {
        list = rankBetweenGroupMapper.selectAll();

    }

    @Override
    public void rankByDayAverageMinutes() {
        Collections.sort(list, new Comparator<RankBetweenGroup>() {
            @Override
            public int compare(RankBetweenGroup t1, RankBetweenGroup t2) {
                return t2.getDayAverageMinutes().compareTo(t1.getDayAverageMinutes());
            }
        });
    }

    public void rankByWeekAverageMinutes() {
        Collections.sort(list, new Comparator<RankBetweenGroup>() {
            @Override
            public int compare(RankBetweenGroup t1, RankBetweenGroup t2) {
                return t2.getWeekAverageMinutes().compareTo(t1.getWeekAverageMinutes());
            }
        });
    }

    public List<RankBetweenGroup> getList() {
        return list;
    }
}
