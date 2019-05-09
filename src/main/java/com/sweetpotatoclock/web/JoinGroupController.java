package com.sweetpotatoclock.web;


import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.entity.RankBetweenGroup;
import com.sweetpotatoclock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JoinGroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GoalCompleteService goalCompleteService;
    @Autowired
    private RankInGroupService rankInGroupService;
    @Autowired
    private RankBetweenGroupService rankBetweenGroupService;
    @Autowired
    private UserInformationService userInformationService;

    @RequestMapping("joinGroup")
    public Map<String, Integer> joinGroup(@RequestParam("groupid") Integer groupId, @RequestParam("userid") String userId) {
        Map<String, Integer> res = new HashMap<>();
        try {
            //判断积分是否足够加入小组
            //扣除对应userId的积分
            //获取要加入的小组数据
            Group group=groupService.getGroupByGroupId(groupId);
            int updateUser = userInformationService.updateUserScoreInJoin(userId, group.getJoinScore());
            System.out.print(updateUser+"\n");
            if(updateUser==2){
                res.put("success",2);
                return res;
            } else if (goalCompleteService.addGoalCompleteInCreate(groupId, userId) == true) {
                //获取更新人员数量后的小组数据
                Group groupNew = groupService.updateGroupMemberNumber(groupId);
                Integer memberBefore = groupNew.getMemberNumber() - 1;
                Integer memberNew = groupNew.getMemberNumber();
                System.out.print(groupNew+"\n");
                rankInGroupService.addRankInGroupInCreate(groupId, userId);
                //计算RankInGroup、RankBetweenGroup中的数值并更新
                RankBetweenGroup rankBetweenGroup = rankBetweenGroupService.getRankBetweenGroupById(groupId);
                Double dayMinutesBefore = rankBetweenGroup.getDayAverageMinutes();
                Double weekMinutesBefore = rankBetweenGroup.getWeekAverageMinutes();
                Double dayMinutesNew = (dayMinutesBefore * memberBefore) / memberNew;
                Double weekMinutesNew = (weekMinutesBefore * memberBefore) / memberNew;
                rankBetweenGroup.setDayAverageMinutes(dayMinutesNew);
                rankBetweenGroup.setWeekAverageMinutes(weekMinutesNew);
                if (rankBetweenGroupService.updateRankBetweenGroup(rankBetweenGroup) == true) {
                    res.put("success", 1);
                    return res;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.put("success", 0);
        return res;
    }
}
