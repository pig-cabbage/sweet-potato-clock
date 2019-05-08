package com.sweetpotatoclock.service.impl;

import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.entity.RankBetweenGroup;
import com.sweetpotatoclock.service.ComputeRankBetweenGroupService;
import com.sweetpotatoclock.service.GroupService;
import com.sweetpotatoclock.service.RankBetweenGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputeRankBetweenGroupServiceImpl implements ComputeRankBetweenGroupService {
    @Autowired
    RankBetweenGroupService rankBetweenGroupService;
    @Autowired
    GroupService groupService;

    @Override
    public RankBetweenGroup computeRankBetweenGroupMinutes(Integer groupId, Integer minutes) {
        //查找对应groupId的RankBetweenGroup对象以及Group对象
        RankBetweenGroup rankBetweenGroup = rankBetweenGroupService.getRankBetweenGroupById(groupId);
        Group group = groupService.getGroupByGroupId(groupId);
        //System.out.print(rankBetweenGroup+"\n");
        //计算新的day_average_minutes，新day_average_minutes=(旧day_average_minutes*member_number+minutes)/member_number
        Double dayMinutes = rankBetweenGroup.getDayAverageMinutes();
        Integer memberNumber = group.getMemberNumber();
        Double newDayMinutes = (dayMinutes*memberNumber+minutes)/memberNumber;
        rankBetweenGroup.setDayAverageMinutes(newDayMinutes);
        //计算新的week_average_minutes，新week_average_minutes=(旧week_average_minutes*member_number+minutes)/member_number
        Double weekMinutes = rankBetweenGroup.getWeekAverageMinutes();
        Double newWeekMinutes = (weekMinutes*memberNumber+minutes)/memberNumber;
        rankBetweenGroup.setWeekAverageMinutes(newWeekMinutes);
        return rankBetweenGroup;
    }
}
