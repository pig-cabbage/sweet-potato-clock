package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.*;
import com.sweetpotatoclock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private GoalDayCompleteController goalDayCompleteController;
    @Autowired
    private UserInformationService userInformationService;
    @Autowired
    private GroupService groupService;

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
                //更新userInformation中的minutesSum和daysSum
                userInformationService.updateUserScoreInClock(record.getUserId(),record.getMinutes());
                //更新goal_complete表
                GoalComplete goalComplete= goalCompleteService.updateGoalComplete(record.getGroupId(),record.getUserId());
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
                    if(rankBetweenGroupService.updateRankBetweenGroup(rankBetweenGroup)) {
                        results.put("success", 1);
                        return results;
                    }
                }
                Double completionNew=goalComplete.getCompletion();
                if(completionNew>=0.99){
                    GoalDayComplete goalDayComplete=new GoalDayComplete();
                    goalDayComplete.setGroupId(groupId);
                    goalDayComplete.setUserId(record.getUserId());
                    goalDayCompleteController.addGoalDayComplete(goalDayComplete);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        results.put("success",0);
        return results;
    }

    @RequestMapping("/getrecordbyuserid")
    public Map<String,Object> getRecordByUserId(@RequestParam("userid") String userId){
        Map<String,Object> result = new HashMap<>();
        List<Record> recordList=recordService.getRecordByUserId(userId);
        List<String> groupNameList = new ArrayList<>();
        for(int i=0;i<recordList.size();i++){
            groupNameList.add(groupService.getGroupByGroupId(recordList.get(i).getGroupId()).getGroupName());
        }
        result.put("records",recordList);
        result.put("groupNames",groupNameList);
        return result;
    }
}
