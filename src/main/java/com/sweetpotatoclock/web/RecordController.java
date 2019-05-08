package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.entity.RankBetweenGroup;
import com.sweetpotatoclock.entity.RankInGroup;
import com.sweetpotatoclock.entity.Record;
import com.sweetpotatoclock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private RankInGroupService rankInGroupService;
    @Autowired
    private RankBetweenGroupService rankBetweenGroupService;
    @Autowired
    private ComputeRankBetweenGroupService computeRankBetweenGroupService;
    @Autowired
    private GoalCompleteService goalCompleteService;

    /**
     * 打卡完成后增加记录，更新排名
     * @param record
     * @return
     */
    @RequestMapping(value = "/completegoal",method = RequestMethod.POST)
    public Map<String,Object> completeGoal(@RequestBody Record record){
        Map<String,Object> results = new HashMap<>();
        System.out.print("record:"+record+"\n");
        if(recordService.addRecord(record)==true){
            try {
                //更新goal_complete表
                goalCompleteService.updateGoalComplete(record.getGroupId(),record.getUserId());
                RankInGroup rankInGroup = new RankInGroup();
                Integer groupId = record.getGroupId();
                Integer minutes = record.getMinutes();
                //将RankInGroup中的dayMinutes更新
                rankInGroup.setGroupId(groupId);
                rankInGroup.setUserId(record.getUserId());
                rankInGroup.setDayMinutes(minutes);
                //将RankInGroup中的weekMinutes更新
                RankInGroup rankInGroup1=rankInGroupService.updateWeekMinutes(rankInGroup);
                //更新数据库rank_in_group表
                if(rankInGroupService.updateRankInGroup(rankInGroup1)==true){
                    //计算新的day_average_minutes和week_average_minutes
                    RankBetweenGroup rankBetweenGroup=computeRankBetweenGroupService.computeRankBetweenGroupMinutes(groupId,minutes);
                    //更新数据库rank_between_group表
                    if(rankBetweenGroupService.updateRankBetweenGroup(rankBetweenGroup)){
                        results.put("success",1);
                        return results;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        results.put("success",0);
        return results;
    }
}
