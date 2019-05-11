package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.GroupMapper;
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

    @Autowired
    private GroupMapper groupMapper;





    @Override
    public RankBetweenGroup getRankBetweenGroupById(Integer groupId) {
        return rankBetweenGroupMapper.selectByPrimaryKey(groupId);
    }

    @Override
    public List<RankBetweenGroup> rankByDayAverageMinutes() {
        List<RankBetweenGroup>list=new ArrayList<>();
        list=rankBetweenGroupMapper.selectAll();
        Collections.sort(list, new Comparator<RankBetweenGroup>() {
            @Override
            public int compare(RankBetweenGroup t1, RankBetweenGroup t2) {
                return t2.getDayAverageMinutes().compareTo(t1.getDayAverageMinutes());
            }
        });
        return list;
    }

    public List<RankBetweenGroup> rankByWeekAverageMinutes() {
        List<RankBetweenGroup>list=new ArrayList<>();
        list=rankBetweenGroupMapper.selectAll();
        Collections.sort(list, new Comparator<RankBetweenGroup>() {
            @Override
            public int compare(RankBetweenGroup t1, RankBetweenGroup t2) {
                return t2.getWeekAverageMinutes().compareTo(t1.getWeekAverageMinutes());
            }
        });
        return list;
    }



    @Override
    public Boolean updateRankBetweenGroup(RankBetweenGroup rankBetweenGroup) {
        try {
            if(rankBetweenGroupMapper.updateByPrimaryKey(rankBetweenGroup)==1){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean addRankBetweenGroupInCreate(Integer groupId) {
        RankBetweenGroup rankBetweenGroup=new RankBetweenGroup();
        rankBetweenGroup.setWeekAverageMinutes((double) 0);
        rankBetweenGroup.setDayAverageMinutes((double) 0);
        rankBetweenGroup.setGroupId(groupId);
        if(rankBetweenGroupMapper.insert(rankBetweenGroup)==1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteRankBetweenGroup(Integer groupId) {

        if(rankBetweenGroupMapper.deleteByPrimaryKey(groupId)==1){
            return true;
        }
        return false;
    }
    @Override
    public List<String>returnNameListDay(){
        List<String>returnList=new ArrayList<>();
        List<RankBetweenGroup>list=rankByDayAverageMinutes();
        for(int i=0;i<list.size();i++){
            String name=groupMapper.selectByPrimaryKey(list.get(i).getGroupId()).getGroupName();
            returnList.add(name);
        }
        return returnList;
    }

    @Override
    public List<String>returnNameListWeek(){
        List<String>returnList=new ArrayList<>();
        List<RankBetweenGroup>list=rankByWeekAverageMinutes();
        for(int i=0;i<list.size();i++){
            String name=groupMapper.selectByPrimaryKey(list.get(i).getGroupId()).getGroupName();
            returnList.add(name);
        }
        return returnList;
    }
}
