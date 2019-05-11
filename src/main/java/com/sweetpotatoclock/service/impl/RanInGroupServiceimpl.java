package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.dao.RankInGroupMapper;
import com.sweetpotatoclock.dao.UserInformationMapper;
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
    @Autowired
    private UserInformationMapper userInformationMapper;


    @Override
    public List<RankInGroup> rankByDayMinutes(Integer groupId) {
        List<RankInGroup> list = new ArrayList<>();
        list = rankInGroupMapper.selectListByGroupId(groupId);
        Collections.sort(list, new Comparator<RankInGroup>() {
            @Override
            public int compare(RankInGroup t1, RankInGroup t2) {
                return t2.getDayMinutes().compareTo(t1.getDayMinutes());
            }
        });
        return list;
    }

    @Override
    public List<RankInGroup> rankByWeekMinutes(Integer groupId) {
        List<RankInGroup> list = new ArrayList<>();
        list = rankInGroupMapper.selectListByGroupId(groupId);
        Collections.sort(list, new Comparator<RankInGroup>() {
            @Override
            public int compare(RankInGroup t1, RankInGroup t2) {
                return t2.getWeekMinutes().compareTo(t1.getWeekMinutes());
            }
        });
        return list;
    }




    @Override
    public Boolean updateRankInGroup(RankInGroup rankInGroup) {
        try {
            if (rankInGroupMapper.updateById(rankInGroup) == 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public RankInGroup updateWeekMinutes(RankInGroup rankInGroup) {
        List<RankInGroup> rankInGroups = rankInGroupMapper.selectAll();
        for (int i = 0; i < rankInGroups.size(); i++) {
            //选出对应groupId和userId的RankInGroup对象
            RankInGroup item = rankInGroups.get(i);
            if (item.getGroupId().equals(rankInGroup.getGroupId()) && item.getUserId().equals(rankInGroup.getUserId())) {
                //weekMinutes=原来的weekMinutes+最新的dayMinutes
                rankInGroup.setWeekMinutes(item.getWeekMinutes() + rankInGroup.getDayMinutes());
                break;
            }
        }
        return rankInGroup;
    }

    @Override
    public Boolean addRankInGroupInCreate(Integer groupId, String userId) {
        RankInGroup rankInGroup = new RankInGroup();
        rankInGroup.setDayMinutes(0);
        rankInGroup.setWeekMinutes(0);
        rankInGroup.setUserId(userId);
        rankInGroup.setGroupId(groupId);
        if (rankInGroupMapper.insert(rankInGroup) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteRankInGroup(Integer groupId) {

        if (rankInGroupMapper.deleteByGroupId(groupId) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<String> returnNameListDay(Integer groupId) {
        List<String> nameList = new ArrayList<>();
        List<RankInGroup> list = rankByDayMinutes(groupId);
        for (int i = 0; i < list.size(); i++) {
            //将成员名称与成员排名对应添加到nameList
            String name = userInformationMapper.selectByPrimaryKey(list.get(i).getUserId()).getUserNickname();
            nameList.add(name);
            System.out.println(name + "\n");
        }
        return nameList;
    }
    @Override
    public List<String> returnNameListWeek(Integer groupId) {
        List<String> nameList = new ArrayList<>();
        List<RankInGroup> list = rankByWeekMinutes(groupId);
        for (int i = 0; i < list.size(); i++) {
            //将成员名称与成员排名对应添加到nameList
            String name = userInformationMapper.selectByPrimaryKey(list.get(i).getUserId()).getUserNickname();
            nameList.add(name);
            System.out.println(name + "\n");
        }
        return nameList;
    }
}
