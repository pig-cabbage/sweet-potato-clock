package com.sweetpotatoclock.web;

import com.sweetpotatoclock.entity.Group;
import com.sweetpotatoclock.entity.RankInGroup;
import com.sweetpotatoclock.service.GoalCompleteService;
import com.sweetpotatoclock.service.GroupService;
import com.sweetpotatoclock.service.RankBetweenGroupService;
import com.sweetpotatoclock.service.RankInGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CreateGroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private GoalCompleteService goalCompleteService;
    @Autowired
    private RankInGroupService rankInGroupService;
    @Autowired
    private RankBetweenGroupService rankBetweenGroupService;

    @RequestMapping(value = "creategroup",method = RequestMethod.POST)
    public Map<String,Object> createGroup(@RequestBody Group group){
        Map<String,Object> result = new HashMap<>();
        if(groupService.addNewGroup(group)==true){
            List<Group> allGroup = groupService.getAllGroup();
            //获取列表中的最后一个的groupId
            Integer groupId=allGroup.get(allGroup.size()).getGroupId();
            //添加至goal_complete、rank_in_group、rank_between_group表
            goalCompleteService.addGoalCompleteInCreate(groupId,group.getCaptainId());
            rankInGroupService.addRankInGroupInCreate(groupId,group.getCaptainId());
            rankBetweenGroupService.addRankBetweenGroupInCreate(groupId);
            result.put("success",1);
        }
        else result.put("success",0);
        return result;
    }
}
