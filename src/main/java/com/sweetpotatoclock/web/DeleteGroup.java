package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.GoalComplete;
import com.sweetpotatoclock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DeleteGroup {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GoalCompleteService goalCompleteService;
    @Autowired
    private RankInGroupService rankInGroupService;
    @Autowired
    private RankBetweenGroupService rankBetweenGroupService;
    @Autowired
    private RecordService recordService;

    @RequestMapping("/deletegroup")
    public Map<String,Integer> deleteGroup(@RequestParam("groupid")Integer groupId){
        Map<String,Integer> result = new HashMap<>();
        if(goalCompleteService.deleteGroup(groupId)){
            rankInGroupService.deleteRankInGroup(groupId);
            rankBetweenGroupService.deleteRankBetweenGroup(groupId);
            recordService.deleteRecord(groupId);
            groupService.deleteGroup(groupId);
            result.put("success",1);
            return result;
        }
        result.put("success",0);
        return result;
    }
}
